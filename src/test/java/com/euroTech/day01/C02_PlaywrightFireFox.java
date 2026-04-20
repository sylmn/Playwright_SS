package com.euroTech.day01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class C02_PlaywrightFirefox {
    public static void main(String[] args) {


        Playwright playwright=Playwright.create();

//        BrowserType firefox= playwright.firefox();
//        Browser browser= firefox.launch();

        Browser browser=playwright.firefox().launch();      // browser tipi ve browser çalıştırma eylemi tek satırda da gerçekleştiriliebilir

        Page page= browser.newPage();

        page.navigate("https://demoqa.com/");

        System.out.println("page title = " + page.title());

        page.close();
        browser.close();
        playwright.close();
    }
}
