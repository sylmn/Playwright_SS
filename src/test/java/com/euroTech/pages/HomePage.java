package com.euroTech.pages;

import com.euroTech.utils.ConfigurationReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage{
    private Page page;

    private Locator emailBox;
    private Locator passwordBox;
    private Locator loginBtn;

    public HomePage(Page page){
        this.page=page;
        this.emailBox=page.locator("#email");
        this.passwordBox=page.locator("#yourPassword");
        this.loginBtn=page.locator("[type='submit']");
    }

    public void login(){
        emailBox.fill(ConfigurationReader.get("email"));
        passwordBox.fill(ConfigurationReader.get("password"));
        loginBtn.click();
    }
}
