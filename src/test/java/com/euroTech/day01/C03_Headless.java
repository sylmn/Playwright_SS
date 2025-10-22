package com.euroTech.day01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class C03_Headless {
    @Test
    public void headlessTest() {

        Playwright playwright = Playwright.create();

        //Bir browser i fiziki olarak acmak icin headless false yapilir.

        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.hepsiburada.com/");


        page.close();
        browser.close();
        playwright.close();
    }
}
