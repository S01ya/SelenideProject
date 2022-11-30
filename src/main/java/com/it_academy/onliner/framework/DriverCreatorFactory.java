package com.it_academy.onliner.framework;

public final class DriverCreatorFactory {

    private DriverCreatorFactory() {
    }

    public static WebDriverCreator getDriverCreator(String driverType) {
        switch (driverType) {
            case "chrome":
                return new ChromeDriverCreator();
            case "opera":
                return new OperaDriverCreator();
            default:
                return new ChromeDriverCreator();
        }
    }
}
