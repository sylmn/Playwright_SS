package com.euroTech.day01;

import com.microsoft.playwright.*;

import java.awt.*;
import java.util.Arrays;

public class C04_FullScreen {
    public static void main(String[] args) {

        //ekran cozunurluk degerlerini alma

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        System.out.println("width = " + width);
        System.out.println("height = " + height);

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(null) // sistem penceresi boyutuna uyar
        );

        Page page = context.newPage(); // ✅ context üzerinden açtık



        //page.setViewportSize(width, height);
        page.navigate("https://www.hepsiburada.com/");


        page.close();
        browser.close();
        playwright.close();

    }
}
