package com.euroTech.day01;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class C05_BrowserContext {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();

        BrowserType chrome= playwright.chromium();

        Browser browser= chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--window-position=-1920,210")));

        // eğer birden fazla browser a ihtiyaç varsa
        BrowserContext b1= browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        // her browser içn ayrı page set edililr
        Page page01= b1.newPage();

        page01.navigate("https://www.hepsiburada.com/");
        System.out.println("page01.title() = " + page01.title());

        // aynı broserda birden fazla sayfa oluşturulabilir
        Page page02= b1.newPage();
        page02.navigate("https://demoqa.com/");

        // 2. browser
        BrowserContext b2=browser.newContext();
        Page page03= b2.newPage();
        page03.navigate("https://sdettest.eurotechstudy.eu/");
        page03.waitForTimeout(300);

        System.out.println("page02.title() = " + page02.title());
        System.out.println("page03.title() = " + page03.title());


        page02.waitForTimeout(5000);




        page01.close();
        page02.close();
        page03.close();
        browser.close();
        playwright.close();
    }
}
