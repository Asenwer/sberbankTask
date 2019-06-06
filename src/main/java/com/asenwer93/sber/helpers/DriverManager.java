package com.asenwer93.sber.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


/**
 * Singleton для получения WebDriver.
 * Используется при создании страниц. Вызов getDriver() происходит в AbstractPage.
 */
public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager(){}

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new DriverManager();
            String path = new File("").getAbsolutePath() + "\\driver\\chromedriver.exe";
//            System.setProperty("webdriver.gecko.driver", path);
            System.setProperty("webdriver.chrome.driver", path);
//            instance.driver = new FirefoxDriver();
            instance.driver = new ChromeDriver();

            instance.driver = DriverManager.getDriver();
            instance.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            instance.driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
            instance.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        }
        return instance.driver;
    }
}
