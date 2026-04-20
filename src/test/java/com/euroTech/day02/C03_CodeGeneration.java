package com.euroTech.day02;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class C03_CodeGeneration {

    @Test
    public void codeGen() {

        // mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen -----site adresi----"

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://sdettest.eurotechstudy.eu/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill("leeroyjenkins@email.com");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).press("Tab");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("1234.Asdf");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Developers")).click();
            page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("3 mike QA Automation Engineer")).getByRole(AriaRole.LINK).click();
        }
    }
}
