package com.it_academy.onliner.framework;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Selenide.open;

public class DriverCreatorFactory {

    protected static final Logger LOG = LoggerFactory.getLogger(DriverCreatorFactory.class);
    private static  final String DRIVER_TYPE_SYSTEM_PROPERTY = "driverType";

    @Nonnull
    public static synchronized WebDriverCreator createDiverByName(@Nonnull String driverType) {
        switch (driverType) {
            case "chrome":
                return new ChromeDriverCreator();
            case "opera":
                return new OperaDriverCreator();
            case "firefox":
                return new FirefoxDriverCreator();
            case "edge":
                return new EdgeDriverCreator();
            case "remote":
                return new RomoteWebDriverCreator();
            default:
                throw new IllegalArgumentException("now such browser exists: " + driverType);
        }
    }

    public synchronized void  initDriver(String driverType) {
        setDriverTypeSystemProperty(driverType);
        Configuration.browser = DriverProvider.class.getName();
        Configuration.pageLoadTimeout = 200000;
        open();
    }

    private synchronized void setDriverTypeSystemProperty(String driverType) {
        if (driverType == null) {
            setDefaultDriverTypeSystemPropertyIfItWasNoSet();
        } else {
            System.setProperty(DRIVER_TYPE_SYSTEM_PROPERTY, driverType);
        }
    }

    private void setDefaultDriverTypeSystemPropertyIfItWasNoSet() {
        if (System.getProperty(DRIVER_TYPE_SYSTEM_PROPERTY) == null) {
            System.setProperty(DRIVER_TYPE_SYSTEM_PROPERTY, "chrome");
            LOG.info("Default driverTYpe system property has been set to '{}'",
                    System.getProperty(DRIVER_TYPE_SYSTEM_PROPERTY));
        }


    }
}

