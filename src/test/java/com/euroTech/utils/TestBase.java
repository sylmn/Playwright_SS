package com.euroTech.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.util.Arrays;

public class TestBase {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;


    @BeforeMethod
    public void setUp() {
        playwright=Playwright.create();
        String browserType=ConfigurationReader.get("browser");

        switch (browserType){
            case "chrome":
                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(Arrays.asList("--window-position=-1920,180")));
                break;
            case "firefox":
                browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(Arrays.asList("--window-position=-1920,180")));
                break;
            default:
                System.out.println("Unsupported browser type: "+browserType);
        }

        page=browser.newPage();

//        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
//        int width= (int) dimension.getWidth();
//        int height= (int) dimension.getHeight();
//        page.setViewportSize(width,height);

        page.setViewportSize(1900,1000);
    }

    @AfterMethod
    public void tearDown() {
        if (page !=null){
            page.close();
        }
        if (browser!=null){
            browser.close();
        }
        if (playwright!=null){
            playwright.close();
        }
    }
}
