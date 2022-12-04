package com.it_academy.onliner.rest_api;

import com.it_academy.onliner.listeners.AllureListener;
import com.it_academy.onliner.rest_api.model.Product;
import com.it_academy.onliner.rest_api.model.Roll;
import com.it_academy.onliner.rest_api.service.ProductsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class APITestSushivesla {
    private static final Logger LOG = LoggerFactory.getLogger(APITestSushivesla.class);

    @Test
    public void apiTestSushiveslaProducts() {
        List<Product> products = new ProductsService().getProductItems();
        LOG.info("List of products from sushivesla request1 {}", products);
        assertThat(products)
                .as("Some of products name is empty")
                .allMatch(product -> !(product.getName()).isEmpty());
    }

    @Test
    public void apiTestSushiveslaRolls() {
        List<Roll> rolls = new ProductsService().getRollNamePrefixItems();
        LOG.info("List of rolls from request2 after filter {}", rolls);
        assertThat(rolls)
                .as("Some of name_prefix don")
                .allMatch(roll -> roll.getName_prefix().equals("Роллы"));
    }
}
