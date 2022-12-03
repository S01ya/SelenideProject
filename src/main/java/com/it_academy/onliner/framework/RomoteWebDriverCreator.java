package com.it_academy.onliner.framework;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Configuration.browser;

public class RomoteWebDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    public static CapabilityFactory capabilityFactory = new CapabilityFactory();
    @Override
    public RemoteWebDriver create() throws MalformedURLException {
        return new RemoteWebDriver(new URL(""),capabilityFactory.getCapabilities(browser));
    }
}
