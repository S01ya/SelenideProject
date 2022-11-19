package com.it_academy.onliner;

import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.testng.annotations.Test;

public class ComputerAndCategoryTest {
    @Test
    public void testElementsOfCategory (){
        new OnlinerHeader().navigateToOnliner()
                .clickOnCatalog()
                .clickOnCategory("Компьютеры")
                .assertElementsFromCategory();
    }
}
