package com.it_academy.onliner.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverCreator implements WebDriverCreator{
    @Override
    public RemoteWebDriver create() {
        FirefoxDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
