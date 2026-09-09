const { chromium } = require('playwright');

const URL = "http://127.0.0.1:8080/entities/seaf.company.ta.services.logical_links/card?id=jupiter.link.fw_to_servers";

(async () => {
  const browser = await chromium.launch({ headless: true });
  const page = await browser.newPage();

  console.log(`Testing URL: ${URL}`);
  
  try {
    await page.goto(URL, { waitUntil: 'networkidle', timeout: 15000 });
    
    // Check title
    const title = await page.title();
    console.log(`Page Title: ${title}`);

    // Check for "Карточка логической связи" text
    // The main card title from presentations/logical_link.yaml
    const hasText = await page.getByText('Карточка логической связи').isVisible();
    console.log(`Has Card Title: ${hasText}`);

    if (hasText) {
        console.log("SUCCESS: Logical Link Card loaded.");
    } else {
        console.log("FAIL: Logical Link Card title not found on page.");
        await page.screenshot({ path: 'fail_logical_link_card.png' });
    }

  } catch (e) {
    console.error("Error:", e);
  }

  await browser.close();
})();
