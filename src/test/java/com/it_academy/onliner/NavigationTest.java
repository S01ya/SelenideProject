package com.it_academy.onliner;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest{

    @Test
    public void testCatalogNavigationTitles() {
        new OnlinerHeader().navigateToOnliner()
                .clickOnCatalog()
                .assertElementsFromCatalogPanel();
    }
}
