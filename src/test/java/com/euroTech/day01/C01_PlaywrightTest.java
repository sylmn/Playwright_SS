package com.euroTech.day01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.sql.Driver;

public class C01_PlaywrightTest {
    public static void main(String[] args) {

        //handshake protokol icin bir tane playwright objesi olusturulur
        Playwright playwright = Playwright.create();

        // calisilacak olan browser tipi belirlenir
        BrowserType chrome = playwright.chromium();

        // kullanilmak istedigimiz browser ayarlanir
        Browser browser = chrome.launch();

        //browser uzerinde de calisilacak sayfa ayarlanir
        Page page = browser.newPage();

        //playwright in default modu headless dir
        page.navigate("https://sdettest.eurotechstudy.eu/");

        page.close();
        browser.close();
        playwright.close();


    }
}
