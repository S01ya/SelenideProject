package com.it_academy.onliner;

import com.it_academy.onliner.pageobject.OnlinerHeader;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import java.util.List;
import static java.util.Arrays.asList;

public class ComputerAndCategoryTest extends BaseTest {

    @Test
    @Description("This test verifies that category 'Computers and nets' contains some required elements")
    public void testElementsOfCategory() {
        List<String> expectedElementsFromCategory = asList("Ноутбуки, компьютеры, мониторы",
                "Комплектующие", "Хранение данных", "Сетевое оборудование");
        new OnlinerHeader().navigateToOnliner()
                .clickOnCatalog()
                .clickOnCategory("Компьютеры")
                .assertElementsFromCategory(expectedElementsFromCategory);
    }
}
