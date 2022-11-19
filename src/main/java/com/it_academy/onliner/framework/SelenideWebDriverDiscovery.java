package com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;

public class SelenideWebDriverDiscovery implements WebDriverProvider {

    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {
        String driverType = System.getProperty("driverType");
        return DriverCreatorFactory.getDriverCreator(driverType).create();
    }
}
