package com.euroTech.day02;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.util.Arrays;

public class C02_PW_Locators {
    Playwright playwright=Playwright.create();
    BrowserType chrome= playwright.chromium();
    Browser browser= chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(Arrays.asList("--window-position=-1920,180")));
    BrowserContext context= browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,980));
    Page page= context.newPage();

    @Test
    public void pw_Locators() {

        //        Page.getByRole() to locate by explicit and implicit accessibility attributes.
        //        Page.getByText() to locate by text content.
        //        Page.getByLabel() to locate a form control by associated label's text.
        //        Page.getByPlaceholder() to locate an input by placeholder.
        //        Page.getByAltText() to locate an element, usually image, by its text alternative.
        //        Page.getByTitle() to locate an element by its title attribute.
        //        Page.getByTestId() to locate an element based on its data-testid attribute (other attributes can be configured).

        page.navigate("https://practicesoftwaretesting.com/contact");

        //Page.getByLabel() to locate a form control by associated label's text.
        Locator firstName = page.getByLabel("First name");
        firstName.fill("Obi-Wan");
        page.getByLabel("Last name").fill("Kenobi");
        page.waitForTimeout(1000);

        //        Page.getByPlaceholder() to locate an input by placeholder.
        page.getByPlaceholder("Your email *").fill("obi-wan@kenobi.com");
        page.waitForTimeout(1000);

        // locate dropdown
        page.getByLabel("Subject").selectOption(new SelectOption().setLabel("Customer service"));
        page.waitForTimeout(1000);

        page.getByLabel("Message *").fill("Hello there, may the force be with you my dear friend.");
        page.waitForTimeout(1000);

        //        Page.getByRole() to locate by explicit and implicit accessibility attributes.
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Send")).click();
        page.waitForTimeout(1000);

        //        Page.getByAltText() to locate an element, usually image, by its text alternative.
        page.navigate("https://www.kitapyurdu.com/kitap/sevme-sanati-bir-eylem-olarak-sevmek/551120.html");
        page.locator("[id=\"cookiescript_accept\"]").click();
        page.getByAltText("kitapyurdu.com").last().click();

        page.waitForTimeout(2000);


        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    public void writeLikeHumanBeing() {
        // eğer yazma eylemlerinde insan hızında girdi yapmak istiyorsak fill() yerine pressSequentially() kullanılır

        page.navigate("https://practicesoftwaretesting.com/contact");

        //Page.getByLabel() to locate a form control by associated label's text.
        Locator firstName = page.getByLabel("First name");
        firstName.pressSequentially("Obi-Wan",new Locator.PressSequentiallyOptions().setDelay(250));
        page.getByLabel("Last name").pressSequentially("Kenobi",new Locator.PressSequentiallyOptions().setDelay(250));
        page.waitForTimeout(1000);

        //        Page.getByPlaceholder() to locate an input by placeholder.
        page.getByPlaceholder("Your email *").pressSequentially("obiwan@kenobi.com",new Locator.PressSequentiallyOptions().setDelay(250));
        page.waitForTimeout(1000);

        // locate dropdown
        page.getByLabel("Subject").selectOption(new SelectOption().setLabel("Customer service"));
        page.waitForTimeout(1000);

        page.getByLabel("Message *").pressSequentially("Hello there, may the force be with you my dear friend.",new Locator.PressSequentiallyOptions().setDelay(250));
        page.waitForTimeout(1000);







        page.close();
        browser.close();
        playwright.close();
    }
}
