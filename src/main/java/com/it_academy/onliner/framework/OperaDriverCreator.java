package com.it_academy.onliner.framework;
//import io.github.bonigarcia.wdm.managers.OperaDriverManager;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OperaDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public RemoteWebDriver create() {
        // OperaDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}


