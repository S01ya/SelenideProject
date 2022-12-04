package com.it_academy.onliner.utils;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.impl.Screenshot;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class ScreenshotUtils {
    protected static final Logger LOG = LoggerFactory.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
    }

    public static void takeScreenshotAndAttachToAllureReport() {
        try {
            File screenshotAs = Screenshots.takeScreenShotAsFile();
            Date date = new Date();
            String screenshotName = date.toString().concat(" Screenshot");
            Allure.addAttachment(screenshotName, FileUtils.openInputStream(screenshotAs));
        } catch (IOException e) {
            LOG.error("Error creating screenshot");
        }
    }
}
