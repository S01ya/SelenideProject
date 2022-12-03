package com.it_academy.onliner.framework;

import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverCreator implements WebDriverCreator<RemoteWebDriver> {

    @Override
    public RemoteWebDriver create() {
        EdgeDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
