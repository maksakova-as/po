package helpers;

public enum RegistersSystemsPage {
    BAZAR_PAGE("//*[text()[normalize-space(.)='Базар услуг']]"),
    MARKETPLACE_PAGE("//*[text()[normalize-space(.)='Маркетплейс']]"),

    BAZAR_DESCRIPTION("//*[text()[normalize-space(.)=': Монолитная система, реализующая прикладной функционал маркетплейса']]"),
    BAZAR_COMPONENT("//*[text()[normalize-space(.)='Java Server']]"),
    BAZAR_TECHCOMPONENT("//*[text()[normalize-space(.)='ecs-auth-server']]"),

    MARKETPLACE_DESCRIPTION("//*[text()[normalize-space(.)=': Система на микросервисной архитектуре, реализующая прикладной функционал маркетплейса']]"),
    MARKETPLACE_COMPONENT("//*[text()[normalize-space(.)='Нет привязки к техпараметру']]"),
    MARKETPLACE_TECHCOMPONENT("//*[text()[normalize-space(.)='ecs-prod-someserver1']]");

    private String locator;

    RegistersSystemsPage(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
