package com.it_academy.onliner.framework;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface WebDriverCreator<T extends RemoteWebDriver> { //- может быть любым (CromeDriver, Fox,....)
    T create() throws MalformedURLException;        //Creator имплементирует конкр. реализации (хром, опера)
}
