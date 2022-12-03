package com.it_academy.onliner;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.testng.annotations.Test;

public class ProductsFromCategoryTest extends BaseTest{
        @Test
    public void testElementsOfCategoryAccessories (){
        new OnlinerHeader().navigateToOnliner()
                .clickOnCatalog()
                .clickOnCategory("Компьютеры")
            .clickOnCatalogClassifierLink(" Комплектующие ")
                .collectProductsFromCategory();
        }
}

