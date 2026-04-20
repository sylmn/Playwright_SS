package com.euroTech.day02;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class C05_Tracing {
    Playwright playwright=Playwright.create();
    BrowserType chrome= playwright.chromium();
    Browser browser= chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(Arrays.asList("--window-position=-1920,180")));
    BrowserContext context= browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,980));
    Page page= context.newPage();

    String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    @Test
    public void trace() {

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));




        page.navigate("https://sdettest.eurotechstudy.eu/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill("leeroyjenkins@email.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).press("Tab");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("1234.Asdf");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Developers")).click();
        page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("3 mike QA Automation Engineer")).getByRole(AriaRole.LINK).click();




        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("Trace/"+timeStamp+".zip")));



        page.close();
        browser.close();
        playwright.close();
    }

    // trace.playwright.dev
    // içine trace dosyasını sürükle bırak
    // adımları gör
}
