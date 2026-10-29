package displayKaDzoTest.base;

import pages.dzo.regress.ilsanta.DzoIlsantaCardPage;
import pages.dzo.regress.SummaryPage;
import pages.dzo.regress.ilsanta.SchemaDataIlsantaPage;
import pages.dzo.regress.ilsanta.SchemaSystemsInternalPage;
import pages.menu.MenuDzoPage;

public class RegressTest extends BaseTest {

    protected MenuDzoPage menuDzoPage = new MenuDzoPage(driver);
    protected DzoIlsantaCardPage dzoIlsantaCardPage = new DzoIlsantaCardPage(driver);
    protected SummaryPage summaryPage = new SummaryPage(driver);
    protected SchemaDataIlsantaPage schemaDataIlsantaPage = new SchemaDataIlsantaPage(driver);
    protected SchemaSystemsInternalPage schemaSystemsInternalPage = new SchemaSystemsInternalPage(driver);

}
