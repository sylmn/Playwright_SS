package com.euroTech.day02;

import com.euroTech.pages.HomePage;
import com.euroTech.utils.ConfigurationReader;
import com.euroTech.utils.TestBase;
import org.testng.annotations.Test;

public class C06_PomExample extends TestBase {
    @Test
    public void pomExample() {
        HomePage homePage=new HomePage(page);
        page.navigate(ConfigurationReader.get("url"));


        homePage.login();


        page.waitForTimeout(3000);
    }
}
