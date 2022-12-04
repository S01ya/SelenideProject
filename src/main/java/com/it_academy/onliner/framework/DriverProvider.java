package com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;

import static java.lang.Thread.currentThread;

public class DriverProvider implements WebDriverProvider {
    private static final Logger LOG = LoggerFactory.getLogger(DriverProvider.class);
    private static final String DRIVER_TYPE_SYSTEM_PROPERTY = "driverType";

    @Nonnull
    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {
        String driverType = System.getProperty(DRIVER_TYPE_SYSTEM_PROPERTY);
        LOG.info("createDriver thread id {}, driverType is {}", currentThread().getId(), driverType);
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = DriverCreatorFactory
                    .createDiverByName(driverType)
                    .create();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return remoteWebDriver;
    }
}
