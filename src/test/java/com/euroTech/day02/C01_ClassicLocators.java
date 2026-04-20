package com.euroTech.day02;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.Arrays;

public class C01_ClassicLocators {
    Playwright playwright = Playwright.create();
    BrowserType chrome = playwright.chromium();
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(Arrays.asList("--window-position=-1920,210")));
    BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
    Page page = context.newPage();

    @Test
    public void classicLocators() {
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        Locator option1 = page.locator("#checkBoxOption1");
        option1.click();
        page.waitForTimeout(1000);
        //locate with Tag
        Locator pageTitle = page.locator("h1");
        System.out.println("pageTitle.innerText() = " + pageTitle.innerText());
        page.waitForTimeout(1000);
        //locate with attribute
        Locator hideButton = page.locator("[value='Hide']");
        hideButton.click();
        page.waitForTimeout(1000);
        //locate with xpath
        Locator option3 = page.locator("//input[@id='checkBoxOption3']");
        option3.click();

        //locate with class
        Locator openTab = page.locator(".btn-style.class1.class2");
        openTab.click();
        page.waitForTimeout(1000);


        page.close();
        browser.close();
        playwright.close();

    }
    @Test
    public void textLocators() {
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        Locator radioButton = page.locator("text='Radio Button '");
        System.out.println("radioButton.innerText() = " + radioButton.innerText());
        page.waitForTimeout(3000);


        //kismi text eslesmesi ile locate
        Locator suggestionClass = page.locator("text=Suggession");
        System.out.println("suggestionClass.innerText() = " + suggestionClass.innerText());
        page.waitForTimeout(3000);



        page.close();
        browser.close();
        playwright.close();
    }
}
