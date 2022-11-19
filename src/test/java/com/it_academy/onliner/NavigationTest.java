package com.it_academy.onliner;

import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.testng.annotations.Test;

public class NavigationTest {

    @Test
    public void testCatalogNavigationTitles() {
        new OnlinerHeader().navigateToOnliner()
                .clickOnCatalog()
                .assertElementsFromCatalogPanel();
    }
}
