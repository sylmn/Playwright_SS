package com.euroTech.day01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;
import java.util.Arrays;

public class C04_Fullscreen {
    public static void main(String[] args) {
        // ekran çöznürülük değerlerini alalım
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int width= (int) dimension.getWidth();
        int height= (int) dimension.getHeight();

        System.out.println("width = " + width);
        System.out.println("height = " + height);

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(Arrays.asList("--window-position=-1920,210","--start-maximized")));
        Page page= browser.newPage();

      //  page.setViewportSize(width,height);

        page.navigate("https://www.hepsiburada.com/");

        page.close();
        browser.close();
        playwright.close();

    }
}
