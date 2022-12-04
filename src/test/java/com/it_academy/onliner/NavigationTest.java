package com.it_academy.onliner;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class NavigationTest extends BaseTest{

    @Test
    @Description("This test verifies that Catalog Panel contains fool list of required elements")
    public void testCatalogNavigationTitles() {
        List<String> expectedElementsFromCatalogPanel = asList("Onlíner Prime", "Электроника",
                "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт", "Дом и сад",
                "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");
        new OnlinerHeader().navigateToOnliner()
                .clickOnCatalog()
                .assertElementsFromCatalogPanel(expectedElementsFromCatalogPanel);
    }
}
