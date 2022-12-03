package com.it_academy.onliner;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.framework.DriverCreatorFactory;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//@Listeners(AllureListener.class)
public abstract class BaseTest {
DriverCreatorFactory driverCreatorFactory = new DriverCreatorFactory();
    protected static final Logger LOG = LoggerFactory.getLogger(ComputerAndCategoryTest.class);
    @BeforeClass
    @Parameters(value = {"driverType"})
    public void  setup(@Optional String driverType){
        LOG.info("driverType: {}, threadId:{}", driverType, Thread.currentThread().getId());
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
        driverCreatorFactory.initDriver(driverType);
    }
}
