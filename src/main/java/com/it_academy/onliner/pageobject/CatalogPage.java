package com.it_academy.onliner.pageobject;
import com.it_academy.onliner.framework.BasePage;
import java.util.Arrays;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    public static final String ALL_CATALOG_NAVIGATION_CLASSIFIER_LINK =
//    " //span[@class = 'catalog-navigation-classifier__item-title-wrapper']";
            "//span[@class='catalog-navigation-classifier__item-title']/child::*";

    public static final String CATALOG_NAVIGATION_LIST_COMPUTERS_AND_NETS = "//div[@data-id = '2']//div[@class =" +
            " 'catalog-navigation-list__aside-item']/div[normalize-space(text())]";

    public static final String CATALOG_NAVIGATION_CLASSIFIER_LINK_PATTERN =
            "//*[contains(@class, 'catalog-navigation-list__aside-title') and text() = ' Комплектующие ']";

    public static final String CATALOG_NAVIGATION_LIST_PATTERN =
            "//*[contains(@class, 'catalog-navigation-classifier__item')]//*[contains(text(), '%s')]";

    public static final String LIST_OF_PRODUCTS_FROM_CATEGORY =
            "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                    "//span[@class='catalog-navigation-list__dropdown-data']";
    public static final String REGEX_EXP = "([А-Яа-я \\w-]{3,100})\\n\\d*,?\\d*.(товара|товаров)\\nот.\\d*,?\\d* р\\.";

    public CatalogPage assertElementsFromCatalogPanel() {
        $$x("//span[@class='catalog-navigation-classifier__item-title']//*[normalize-space(text())]")
                .shouldHave(size(10), ofSeconds(40))
                        .shouldHave(texts("Onlíner Prime",
                                "Электроника",
                                "Компьютеры и сети",
                                "Бытовая техника",
                                "Стройка и ремонт",
                                "Дом и сад",
                                "Авто и мото",
                                "Красота и спорт",
                                "Детям и мамам",
                                "Работа и офис"));
        return this;
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_NAVIGATION_CLASSIFIER_LINK_PATTERN, link))
                .shouldBe(visible,ofSeconds(10))
                .click();
        return this;
    }

    public CatalogPage assertElementsFromCategory() {
        List<String> expectedElementsFromCategory = Arrays.asList("Ноутбуки,компьютеры, мониторы", "Комплектующие",
                "Хранение данных", "Сетевое оборудование");
        $$x(format(format(CATALOG_NAVIGATION_LIST_COMPUTERS_AND_NETS)))
                .shouldHave(sizeGreaterThan(0), ofSeconds(10))
                .should( containExactTextsCaseSensitive("Ноутбуки, компьютеры, мониторы", "Комплектующие",
                        "Хранение данных", "Сетевое оборудование"));
        return this;
    }

    public CatalogPage clickOnCategory(String link) {
        $x(format(CATALOG_NAVIGATION_LIST_PATTERN, link))
                .shouldBe(visible, ofSeconds(10))
                .click();
        return this;
    }

    public CatalogPage collectProductsFromCategory() {
        $$x(format(format(LIST_OF_PRODUCTS_FROM_CATEGORY)))
                .shouldHave(sizeGreaterThan(0), ofSeconds(10))
                .shouldHave(allMatch("someone don't visible",x -> x.isDisplayed()))
                .should(allMatch("Some product haven't correct format",
                        x -> x.getText().matches(REGEX_EXP)));
        return this;
    }
}