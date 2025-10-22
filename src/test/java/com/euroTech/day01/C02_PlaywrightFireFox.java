package com.euroTech.day01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class C02_PlaywrightFireFox {
    @Test
    public void firefox (){
        Playwright playwright = Playwright.create();

        //BrowserType firefox= playwright.firefox();
        //Browser browser = firefox.launch();
        Browser browser =playwright.firefox().launch();

        Page page = browser.newPage();
        page.navigate("https://demoqa.com/");
        System.out.println("page.title() = " + page.title());


        page.close();
        browser.close();
        playwright.close();
    }
}
