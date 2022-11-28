package com.it_academy.onliner.rest_api;

import com.it_academy.onliner.rest_api.model.Product;
import com.it_academy.onliner.rest_api.service.ProductsService;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class APITestSushivesla {
    @Test
    public void apiTestSushiveslaProducts() {
        List<Product> products = new ProductsService().getProductItems();
        System.out.println(products);
        assertThat(products).allMatch(product -> {
            assertThat(product.getName()).isNotEmpty();
            return true;
        });
    }

    @Test
    public void apiTestSushiveslaRolls(){
        List<String> rolls = new ProductsService().getRollNamePrefixItems();
        System.out.println(rolls);
        assertThat(rolls).allMatch(roll -> {  //так как пришла коллекция в коллекции
            assertThat(roll.equals("Роллы"));
            return true;
        });
    }
}
