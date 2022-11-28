package com.it_academy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints;
import com.it_academy.onliner.rest_api.model.Product;
import com.it_academy.onliner.rest_api.utils.GetRequestUtils;
import com.it_academy.onliner.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductsService {
    private static final String PRODUCTS_JSON_PATH = "products";
    private static final String FILTER_ROLL_JSON_PATH = "products.name_prefix";

    public List<Product> getProductItems() {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getCatalogSearchSushiveslaEndPoint(),
                configureHeaders(), null);
        return ResponseBodyUtils.getObjectsByJsonPath(
                responseBody, PRODUCTS_JSON_PATH, Product.class);
    }

    public List<String> getRollNamePrefixItems() {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getCatalogSearchSushiveslaRollEndPoint(),
                configureHeaders(), null);
        return Collections.singletonList(ResponseBodyUtils.getStringJsonValue(
                responseBody, FILTER_ROLL_JSON_PATH));
    }
    public static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by",
        "Connection", "keep-alive");
    }
}
