const { chromium } = require("playwright");
const fs = require("fs");
const path = require("path");

const URLS_FILE = path.join(__dirname, "urls.json");

function buildResultsFiles(outPrefix) {
  const prefix = (outPrefix ?? "results").toString().trim() || "results";
  return {
    json: path.join(__dirname, `${prefix}.json`),
    md: path.join(__dirname, `${prefix}.md`),
    csv: path.join(__dirname, `${prefix}.csv`),
  };
}

function normalize(text) {
  return (text ?? "").toString().replace(/\s+/g, " ").trim();
}

function normalizeTitle(text) {
  const value = normalize(text);
  return value.replace(/^#+\s*/, "");
}

function escapeMd(text) {
  return (text ?? "").toString().replace(/\|/g, "\\|").replace(/\r?\n/g, " ").trim();
}

function toMdLink(url) {
  const safe = escapeMd(url);
  return `[link](${safe})`;
}

function getEntityName(item) {
  const raw = (item?.name ?? "").toString();
  return raw.includes(" / ") ? raw.split(" / ")[0] : raw;
}

function classifyWidgetHealth({ httpErrors, consoleErrors, pageErrors, bodyText }) {
  const body = normalize(bodyText);
  const hasPlantUmlWord = /plantuml/i.test(body);

  const http = httpErrors ?? [];
  const consoleErr = consoleErrors ?? [];
  const pageErr = pageErrors ?? [];

  const plantumlHttp = http.filter((x) => x.toLowerCase().includes("seafplantuml") || x.toLowerCase().includes("/plantuml") || x.toLowerCase().includes("plantuml"));
  const hasSeafPlantUmlError = plantumlHttp.length > 0;
  const templatePumlHttp = http.filter((x) => x.toLowerCase().includes("/templates/") && (x.toLowerCase().includes(".puml") || x.toLowerCase().includes(".pmu")));
  const hasTemplatePumlError = templatePumlHttp.length > 0;
  const releaseProfileHttp = http.filter((x) => x.toLowerCase().includes("/core/storage/release-data-profile/"));
  const hasReleaseProfileError = releaseProfileHttp.length > 0;

  const hasJsSyntaxError = pageErr.some((x) => /Expected ".+"\), got/i.test(x)) || consoleErr.some((x) => /Expected ".+"\), got/i.test(x));

  const plantuml = hasSeafPlantUmlError || hasTemplatePumlError || (hasPlantUmlWord && (hasReleaseProfileError || hasJsSyntaxError));
  const dataProfile = hasReleaseProfileError;

  return {
    plantuml: plantuml ? "FAIL" : "OK",
    dataProfile: dataProfile ? "WARN" : "OK",
    jsError: pageErr.length > 0 ? "WARN" : "OK",
    evidence: {
      plantumlHttp: plantumlHttp.slice(0, 5),
      templateHttp: templatePumlHttp.slice(0, 5),
      dataProfileHttp: releaseProfileHttp.slice(0, 5),
      console: consoleErr.slice(0, 5),
      page: pageErr.slice(0, 5),
    },
  };
}

(async () => {
  if (!fs.existsSync(URLS_FILE)) {
    console.error(`URLs file not found: ${URLS_FILE}. Run generate_test_urls.py first.`);
    process.exit(1);
  }

  let urls = JSON.parse(fs.readFileSync(URLS_FILE, "utf8"));

  const rawArgs = process.argv.slice(2).filter(Boolean);
  let outPrefix = null;
  const filterArgs = [];

  for (let i = 0; i < rawArgs.length; i++) {
    const a = rawArgs[i];
    if (a === "--out" || a === "--out-prefix") {
      outPrefix = rawArgs[i + 1] ?? null;
      i++;
      continue;
    }
    filterArgs.push(a);
  }

  const filters = filterArgs
    .flatMap((arg) => arg.split(",").map((x) => x.trim()))
    .filter(Boolean);

  const outFiles = buildResultsFiles(outPrefix);

  if (filters.length) {
    console.log(`Filtering tests by patterns: ${filters.map((x) => `"${x}"`).join(", ")}`);
    const lowered = filters.map((x) => x.toLowerCase());
    urls = urls.filter((item) => lowered.some((f) => item.name.toLowerCase().includes(f)));
    if (urls.length === 0) {
      console.error(`No tests found matching patterns: ${filters.join(", ")}`);
      process.exit(1);
    }
  }

  const browser = await chromium.launch({ headless: true });
  const context = await browser.newContext({ ignoreHTTPSErrors: true });
  const page = await context.newPage();

  console.log(`Starting UI Smoke Test on ${urls.length} URLs...\n`);

  let passed = 0;
  let warnings = 0;
  let failed = 0;
  const results = [];

  const detectErrorMarkers = async () => {
    const bodyText = await page.textContent("body").catch(() => "");
    const text = normalize(bodyText);
    if (!text) return { hard: false, soft: false };

    const hard =
      /Cannot GET\s+\//i.test(text) ||
      /Internal Server Error/i.test(text) ||
      /Traceback/i.test(text) ||
      /Произошла ошибка/i.test(text) ||
      /Ошибка загрузки!/i.test(text);

    const soft =
      /Ошибка построения/i.test(text) ||
      /Attempted to invoke a non-function/i.test(text) ||
      /No terminating \//i.test(text) ||
      /Expected ".+?", got ".+?"/i.test(text) ||
      /Код ошибки\s*:/i.test(text);

    return { hard, soft };
  };

  const detectPersistentMarkers = async () => {
    const first = await detectErrorMarkers();
    if (first.hard) return first;
    if (!first.soft) return first;
    await page.waitForTimeout(1000);
    const second = await detectErrorMarkers();
    return { hard: second.hard, soft: second.soft };
  };

  for (const item of urls) {
    const isCard = item.type === "Card";
    process.stdout.write(`Testing [${item.type}] ${item.name}... `);
    const startedAt = Date.now();
    const consoleErrors = [];
    const pageErrors = [];
    const requestFailed = [];
    const httpErrors = [];
    const plantumlPayloads = [];

    const onPageError = (err) => pageErrors.push(String(err));
    const onConsole = (msg) => {
      if (msg.type() === "error") consoleErrors.push(msg.text());
    };
    const onRequestFailed = (req) => requestFailed.push(`${req.method()} ${req.url()} :: ${req.failure()?.errorText}`);
    const onResponse = (res) => {
      if (res.status() >= 400) {
        const url = res.url();
        httpErrors.push(`${res.status()} ${res.request().method()} ${url}`);
        if (url.toLowerCase().includes("seafplantuml")) {
          try {
            const req = res.request();
            const buf = typeof req.postDataBuffer === "function" ? req.postDataBuffer() : null;
            if (buf && buf.length) {
              plantumlPayloads.push({ encoding: "base64", data: buf.toString("base64").slice(0, 8000) });
            } else {
              const payload = req.postData();
              if (payload) plantumlPayloads.push({ encoding: "text", data: payload.slice(0, 1000) });
            }
          } catch (e) {
            // ignore
          }
        }
      }
    };

    page.on("pageerror", onPageError);
    page.on("console", onConsole);
    page.on("requestfailed", onRequestFailed);
    page.on("response", onResponse);

    try {
      await page.goto(item.url, { waitUntil: "domcontentloaded", timeout: 30000 });
      await page.waitForTimeout(750);

      if (isCard) {
        try {
          const expectedTitle = typeof item.expectedTitle === "string" ? item.expectedTitle.trim() : "";
          if (expectedTitle) {
            let titleFound = false;
            try {
              await page.getByText(expectedTitle, { exact: false }).first().waitFor({ timeout: 10000 });
              titleFound = true;
            } catch (e) {
              titleFound = false;
            }
            if (!titleFound) {
              const headerText1 = await page.textContent("css=h1").catch(() => "");
              const headerText2 = await page.textContent("css=h2").catch(() => "");
              const headerText = normalize(headerText1) ? headerText1 : headerText2;
              const normalizedExpected = normalizeTitle(expectedTitle);
              const normalizedHeader = normalizeTitle(headerText);
              if (normalizedHeader && normalizedHeader.includes(normalizedExpected)) {
                titleFound = true;
              }
            }
            if (!titleFound) {
              let headerFound = false;
              try {
                await page.waitForSelector("css=h1", { timeout: 15000 });
                headerFound = true;
              } catch (e) {
                const headerText1 = await page.textContent("css=h1").catch(() => "");
                const headerText2 = await page.textContent("css=h2").catch(() => "");
                headerFound = normalize(headerText1).length > 0 || normalize(headerText2).length > 0;
              }
              await page.waitForTimeout(1000);
              const markers = await detectPersistentMarkers();
              const bodyText = await page.textContent("body").catch(() => "");
              const widget = classifyWidgetHealth({ httpErrors, consoleErrors, pageErrors, bodyText });
              if (markers.hard) {
                console.log("FAIL (Hard error detected)");
                failed++;
                results.push({
                  ...item,
                  status: "FAIL",
                  message: "Hard error detected",
                  diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                  durationMs: Date.now() - startedAt,
                });
              } else if (headerFound) {
                console.log("WARN (Header found, expectedTitle not found)");
                warnings++;
                results.push({
                  ...item,
                  status: "WARN",
                  message: "Header found, expectedTitle not found",
                  diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                  durationMs: Date.now() - startedAt,
                });
              } else {
                console.log("FAIL (Expected title not found and header missing)");
                failed++;
                results.push({
                  ...item,
                  status: "FAIL",
                  message: "Expected title not found and header missing",
                  diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                  durationMs: Date.now() - startedAt,
                });
              }
              continue;
            }

            await page.waitForTimeout(1000);
            const markers = await detectPersistentMarkers();
            const bodyText = await page.textContent("body").catch(() => "");
            const widget = classifyWidgetHealth({ httpErrors, consoleErrors, pageErrors, bodyText });
            if (markers.hard) {
              console.log("FAIL (Hard error detected)");
              failed++;
              results.push({
                ...item,
                status: "FAIL",
                message: "Hard error detected",
                diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                durationMs: Date.now() - startedAt,
              });
            } else if (markers.soft) {
              console.log("WARN (Card loaded but error marker detected)");
              warnings++;
              results.push({
                ...item,
                status: "WARN",
                message: "Card loaded but error marker detected",
                diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                durationMs: Date.now() - startedAt,
              });
            } else {
              if (widget.plantuml === "FAIL") {
                console.log("WARN (PlantUML errors detected)");
                warnings++;
                results.push({
                  ...item,
                  status: "WARN",
                  message: "PlantUML errors detected",
                  diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                  durationMs: Date.now() - startedAt,
                });
              } else {
                console.log("OK");
                passed++;
                results.push({
                  ...item,
                  status: "OK",
                  message: "",
                  diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                  durationMs: Date.now() - startedAt,
                });
              }
            }
          } else {
            let headerFound = false;
            try {
              await page.waitForSelector("css=h1", { timeout: 15000 });
              headerFound = true;
            } catch (e) {
              const headerText1 = await page.textContent("css=h1").catch(() => "");
              const headerText2 = await page.textContent("css=h2").catch(() => "");
              headerFound = normalize(headerText1).length > 0 || normalize(headerText2).length > 0;
            }
            if (!headerFound) {
              await Promise.any([
                page.waitForSelector("table", { timeout: 7000 }),
                page.waitForSelector("p:not(:empty)", { timeout: 7000 }),
              ]);
            }
            await page.waitForTimeout(1000);
            const markers = await detectPersistentMarkers();
            const bodyText = await page.textContent("body").catch(() => "");
            const widget = classifyWidgetHealth({ httpErrors, consoleErrors, pageErrors, bodyText });
            if (markers.hard) {
              console.log("FAIL (Hard error detected)");
              failed++;
              results.push({
                ...item,
                status: "FAIL",
                message: "Hard error detected",
                diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                durationMs: Date.now() - startedAt,
              });
            } else if (markers.soft) {
              console.log("WARN (No expectedTitle; error marker detected)");
              warnings++;
              results.push({
                ...item,
                status: "WARN",
                message: "No expectedTitle; error marker detected",
                diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                durationMs: Date.now() - startedAt,
              });
            } else {
              if (widget.plantuml === "FAIL") {
                console.log("WARN (No expectedTitle; PlantUML errors detected)");
                warnings++;
                results.push({
                  ...item,
                  status: "WARN",
                  message: "No expectedTitle; PlantUML errors detected",
                  diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                  durationMs: Date.now() - startedAt,
                });
              } else {
                if (headerFound) {
                  console.log("OK");
                  passed++;
                  results.push({
                    ...item,
                    status: "OK",
                    message: "",
                    diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                    durationMs: Date.now() - startedAt,
                  });
                } else {
                  console.log("WARN (No expectedTitle; generic content check)");
                  warnings++;
                  results.push({
                    ...item,
                    status: "WARN",
                    message: "No expectedTitle; generic content check",
                    diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                    durationMs: Date.now() - startedAt,
                  });
                }
              }
            }
          }
        } catch (e) {
          console.log(`FAIL (Card check failed: ${e.message})`);
          failed++;
          results.push({
            ...item,
            status: "FAIL",
            message: `Card check failed: ${e.message}`,
            diagnostics: { httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
            durationMs: Date.now() - startedAt,
          });
        }
      } else {
        try {
          await page.waitForSelector("table", { timeout: 7000 });
          const rows = await page.$$("tr");
          if (rows.length > 1) {
            await page.waitForTimeout(1000);
            const markers = await detectPersistentMarkers();
            const bodyText = await page.textContent("body").catch(() => "");
            const widget = classifyWidgetHealth({ httpErrors, consoleErrors, pageErrors, bodyText });
            if (markers.hard) {
              console.log("FAIL (Hard error detected)");
              failed++;
              results.push({
                ...item,
                status: "FAIL",
                message: "Hard error detected",
                diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                durationMs: Date.now() - startedAt,
              });
            } else if (markers.soft) {
              console.log(`WARN (List OK: ${rows.length} rows; error marker detected)`);
              warnings++;
              results.push({
                ...item,
                status: "WARN",
                message: `List OK: ${rows.length} rows; error marker detected`,
                diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                durationMs: Date.now() - startedAt,
              });
            } else {
              console.log(`OK (${rows.length} rows)`);
              passed++;
              results.push({
                ...item,
                status: "OK",
                message: `Rows: ${rows.length}`,
                diagnostics: { widget, httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
                durationMs: Date.now() - startedAt,
              });
            }
          } else {
            console.log("WARN (Table found but appears empty or only has headers)");
            warnings++;
            results.push({
              ...item,
              status: "WARN",
              message: "Table found but appears empty or only has headers",
              diagnostics: { httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
              durationMs: Date.now() - startedAt,
            });
          }
        } catch (e) {
          console.log(`FAIL (Table not found: ${e.message})`);
          failed++;
          results.push({
            ...item,
            status: "FAIL",
            message: `Table not found: ${e.message}`,
            diagnostics: { httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
            durationMs: Date.now() - startedAt,
          });
        }
      }
    } catch (e) {
      console.log(`FAIL (Network/Load Error: ${e.message})`);
      failed++;
      results.push({
        ...item,
        status: "FAIL",
        message: `Network/Load Error: ${e.message}`,
        diagnostics: { httpErrors, consoleErrors, pageErrors, requestFailed, plantumlPayloads },
        durationMs: Date.now() - startedAt,
      });
    } finally {
      page.off("pageerror", onPageError);
      page.off("console", onConsole);
      page.off("requestfailed", onRequestFailed);
      page.off("response", onResponse);
    }
  }

  await browser.close();

  const meta = {
    generatedAt: new Date().toISOString(),
    total: urls.length,
    passed,
    warnings,
    failed,
    filters: filters.length ? filters : null,
    outPrefix: outPrefix || null,
  };

  fs.writeFileSync(outFiles.json, JSON.stringify({ meta, results }, null, 2), "utf8");

  const entitySummary = {};
  for (const r of results) {
    const entity = getEntityName(r);
    const key = `${r.type}::${entity}`;
    if (!entitySummary[key]) entitySummary[key] = { type: r.type, entity, total: 0, ok: 0, warn: 0, fail: 0, plantumlFail: 0, dataProfileWarn: 0 };
    entitySummary[key].total++;
    if (r.status === "OK") entitySummary[key].ok++;
    else if (r.status === "WARN") entitySummary[key].warn++;
    else entitySummary[key].fail++;
    const widget = r.diagnostics?.widget;
    if (widget?.plantuml === "FAIL") entitySummary[key].plantumlFail++;
    if (widget?.dataProfile === "WARN") entitySummary[key].dataProfileWarn++;
  }

  const mdLines = [];
  mdLines.push(`# UI Smoke Results`);
  mdLines.push(``);
  mdLines.push(`Generated at: \`${meta.generatedAt}\``);
  mdLines.push(`Total: **${meta.total}**, OK: **${meta.passed}**, WARN: **${meta.warnings}**, FAIL: **${meta.failed}**`);
  if (meta.filters?.length) mdLines.push(`Filter: \`${escapeMd(meta.filters.join(", "))}\``);
  mdLines.push(``);
  mdLines.push(`## Summary by entity`);
  mdLines.push(``);
  mdLines.push(`| Type | Entity | Total | OK | WARN | FAIL | PlantUML FAIL | DataProfile WARN |`);
  mdLines.push(`|---|---|---:|---:|---:|---:|---:|---:|`);
  for (const k of Object.keys(entitySummary).sort()) {
    const s = entitySummary[k];
    mdLines.push(`| ${escapeMd(s.type)} | ${escapeMd(s.entity)} | ${s.total} | ${s.ok} | ${s.warn} | ${s.fail} | ${s.plantumlFail} | ${s.dataProfileWarn} |`);
  }
  mdLines.push(``);
  mdLines.push(`## Details`);
  mdLines.push(``);
  mdLines.push(`| Status | Type | Entity | ID | Source | PlantUML | DataProfile | Net4xx/5xx | ConsoleErr | PageErr | Dataset | URL | Message |`);
  mdLines.push(`|---|---|---|---|---|---|---|---:|---:|---:|---|---|---|`);
  for (const r of results) {
    const entity = getEntityName(r);
    const widget = r.diagnostics?.widget || {};
    const httpErrCount = Array.isArray(r.diagnostics?.httpErrors) ? r.diagnostics.httpErrors.length : 0;
    const consoleErrCount = Array.isArray(r.diagnostics?.consoleErrors) ? r.diagnostics.consoleErrors.length : 0;
    const pageErrCount = Array.isArray(r.diagnostics?.pageErrors) ? r.diagnostics.pageErrors.length : 0;
    mdLines.push(
      `| ${escapeMd(r.status)} | ${escapeMd(r.type)} | ${escapeMd(entity)} | ${escapeMd(r.id || "")} | ${escapeMd(r.source || "")} | ${escapeMd(widget.plantuml || "")} | ${escapeMd(widget.dataProfile || "")} | ${httpErrCount} | ${consoleErrCount} | ${pageErrCount} | ${escapeMd(r.dataset || "")} | ${toMdLink(r.url)} | ${escapeMd(r.message || "")} |`
    );
  }
  fs.writeFileSync(outFiles.md, mdLines.join("\n"), "utf8");

  const csvEscape = (value) => {
    const s = (value ?? "").toString();
    if (s.includes('"') || s.includes(",") || s.includes("\n") || s.includes("\r")) {
      return `"${s.replace(/"/g, '""')}"`;
    }
    return s;
  };

  const csvLines = [];
  csvLines.push(
    [
      "status",
      "type",
      "entity",
      "id",
      "source",
      "plantuml",
      "dataProfile",
      "net4xx5xx",
      "consoleErr",
      "pageErr",
      "durationMs",
      "dataset",
      "url",
      "message",
      "plantumlEvidence",
    ].join(",")
  );

  for (const r of results) {
    const entity = getEntityName(r);
    const widget = r.diagnostics?.widget || {};
    const httpErrCount = Array.isArray(r.diagnostics?.httpErrors) ? r.diagnostics.httpErrors.length : 0;
    const consoleErrCount = Array.isArray(r.diagnostics?.consoleErrors) ? r.diagnostics.consoleErrors.length : 0;
    const pageErrCount = Array.isArray(r.diagnostics?.pageErrors) ? r.diagnostics.pageErrors.length : 0;
    const evidence = widget?.evidence?.plantumlHttp?.join(" | ") || widget?.evidence?.templateHttp?.join(" | ") || "";

    csvLines.push(
      [
        r.status || "",
        r.type || "",
        entity || "",
        r.id || "",
        r.source || "",
        widget.plantuml || "",
        widget.dataProfile || "",
        httpErrCount,
        consoleErrCount,
        pageErrCount,
        r.durationMs ?? "",
        r.dataset || "",
        r.url || "",
        r.message || "",
        evidence,
      ]
        .map(csvEscape)
        .join(",")
    );
  }
  fs.writeFileSync(outFiles.csv, csvLines.join("\n"), "utf8");

  console.log("\n--- Summary ---");
  console.log(`Total: ${urls.length}`);
  console.log(`Passed: ${passed}`);
  console.log(`Warnings: ${warnings}`);
  console.log(`Failed: ${failed}`);
  console.log(`\nWrote: ${outFiles.md}`);
  console.log(`Wrote: ${outFiles.json}`);
  console.log(`Wrote: ${outFiles.csv}`);

  if (failed > 0) process.exit(1);
})();
