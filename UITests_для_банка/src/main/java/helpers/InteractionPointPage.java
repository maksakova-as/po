package helpers;

public enum InteractionPointPage {

    BEREZKA_ENDPOINT("//a[text()[normalize-space(.)='ecogroup.berezka.fias_endpoint']]"),
    BEREZKA_POINT ("//a[text()[normalize-space(.)='ecogroup.berezka.message_point']]"),
    FIAS("//*[text()[normalize-space(.)='ФИАС']]"),
    PULL("//*[text()[contains(normalize-space(.),'Pull')]]");

    private String locator;

    InteractionPointPage(String locator) {
        this.locator = locator;
    }

    public String getLocator(){
        return locator;
    }
}
