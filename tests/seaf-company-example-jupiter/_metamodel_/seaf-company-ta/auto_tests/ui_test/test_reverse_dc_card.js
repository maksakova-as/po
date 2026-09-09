const { chromium } = require('playwright');

const URL = "http://127.0.0.1:8080/entities/seaf.company.ta.services.dcs/card?id=reverse.dc.ru-moscow-1a";

(async () => {
  const browser = await chromium.launch({ headless: true });
  const page = await browser.newPage();

  console.log(`Testing URL: ${URL}`);
  
  try {
    await page.goto(URL, { waitUntil: 'networkidle', timeout: 15000 });
    
    // Check title
    const title = await page.title();
    console.log(`Page Title: ${title}`);

    // Check for "Sber Cloud DC (ru-moscow-1a)" text
    const hasText = await page.getByText('Sber Cloud DC (ru-moscow-1a)').isVisible();
    console.log(`Has Object Title: ${hasText}`);

    if (hasText) {
        console.log("SUCCESS: Card loaded with correct data.");
    } else {
        console.log("FAIL: Object title not found on page.");
        // Take screenshot
        await page.screenshot({ path: 'fail_reverse_dc.png' });
    }

  } catch (e) {
    console.error("Error:", e);
  }

  await browser.close();
})();