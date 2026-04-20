package com.euroTech.day02;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.util.Arrays;

public class C04_Pause_Debug {
    Playwright playwright=Playwright.create();
    BrowserType chrome= playwright.chromium();
    Browser browser= chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(Arrays.asList("--window-position=-1920,180")));
    BrowserContext context= browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,980));
    Page page= context.newPage();
    @Test
    public void pause() {

        page.navigate("https://sdettest.eurotechstudy.eu/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill("leeroyjenkins@email.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).press("Tab");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("1234.Asdf");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        // pause
        page.pause();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Developers")).click();
        page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("3 mike QA Automation Engineer")).getByRole(AriaRole.LINK).click();





        page.close();
        browser.close();
        playwright.close();
    }


    @Test
    public void debug() {

        page.navigate("https://sdettest.eurotechstudy.eu/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill("leeroyjenkins@email.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).press("Tab");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("1234.Asdf");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Developers")).click();
        page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("3 mike QA Automation Engineer")).getByRole(AriaRole.LINK).click();





        page.close();
        browser.close();
        playwright.close();
    }
}
