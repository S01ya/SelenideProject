package com.it_academy.onliner.rest_api.endpoints;
import com.it_academy.onliner.framework.PropertiesReader;

public class OnlinerEndpoints {
    public static String getCatalogSearchSushiveslaEndPoint() {
        return PropertiesReader.getEndpointProperty("catalog.search.sushivesla");
    }

    public static String getCatalogSearchSushiveslaRollEndPoint() {
        return PropertiesReader.getEndpointProperty("catalog.search.sushivesla.roll");
    }
}
