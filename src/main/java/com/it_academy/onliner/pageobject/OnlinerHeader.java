package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class OnlinerHeader extends BasePage {

    private static final String ONLINER_URL = "https://www.onliner.by/";
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    public OnlinerHeader navigateToOnliner() {
        open(ONLINER_URL);
        return this;
    }

    public void clickOnMainNavigationLink(String link) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(10))
                .click();
    }

    public CatalogPage clickOnCatalog() {
        clickOnMainNavigationLink("Каталог");
        return new CatalogPage();
    }
}
