package com.euroTech.day01;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class C06_Screenshot {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext b1 = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page01 = b1.newPage();

        page01.navigate("https://www.amazon.com/");

        page01.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("SS/screenshot.png")));

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        page01.navigate("https://www.hepsiburada.com");
        page01.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("SS/"+timeStamp+"screenshot.png")));


        page01.close();
        browser.close();
        playwright.close();
    }
}
