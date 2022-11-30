package com.it_academy.onliner.framework;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OperaDriverCreator implements WebDriverCreator<RemoteWebDriver>{
    @Override
    public RemoteWebDriver create() {
        return new OperaDriver();
    }
}


