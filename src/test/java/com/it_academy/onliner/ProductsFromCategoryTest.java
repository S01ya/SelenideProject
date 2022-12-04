package com.it_academy.onliner;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ProductsFromCategoryTest extends BaseTest{
        @Test
        @Description("This test verifies that section 'Accessories'  from category 'Computers " +
                "and nets' contains elements with names, price, and amount of goods")
    public void testElementsOfCategoryAccessories (){
        new OnlinerHeader().navigateToOnliner()
                .clickOnCatalog()
                .clickOnCategory("Компьютеры")
            .clickOnCatalogClassifierLink(" Комплектующие ")
                .collectProductsFromCategory();
        }
}

