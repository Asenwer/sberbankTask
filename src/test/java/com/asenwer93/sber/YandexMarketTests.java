package com.asenwer93.sber;

import com.asenwer93.sber.helpers.DriverManager;
import com.asenwer93.sber.pages.market.laptop.LaptopSubcategoryPage;
import com.asenwer93.sber.pages.market.YandexMarketMainPage;
import com.asenwer93.sber.pages.YandexSearchPage;
import com.asenwer93.sber.pages.market.tablets.TabletSubcategoryPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class YandexMarketTests {
    @BeforeMethod
    public void beforeTest() {
        BrowserManagement browserManagement = new BrowserManagement();
        browserManagement.windowMaximize();
    }

    @AfterTest
    public static void afterTest() {
        DriverManager.getDriver().quit();
    }

    @Description("Тестирование категории ноутбуки")
    @Test
    public void test1() {
        SoftAssert softAssert = new SoftAssert();
        YandexSearchPage yandexSearchPage = new YandexSearchPage();
        LaptopSubcategoryPage laptopPage = (LaptopSubcategoryPage) yandexSearchPage.load()
                .goToMarket()
                .goToCategory("Компьютерная техника")
                .goToTheSubcategory(YandexMarketMainPage.Subcategory.LAPTOP);

        laptopPage.goToAllFilters()
                .setPrice(0, 30_000)
                .selectCompanies("HP", "Lenovo")
                .apply();
        softAssert.assertEquals(laptopPage.countElements(), 10);

        String nameFirstElement = laptopPage.getNameElement(0);

        laptopPage.searchElementByName(nameFirstElement);
        softAssert.assertEquals(laptopPage.getNameElement(0), nameFirstElement);

        softAssert.assertAll();
    }

    @Description("Тестирование категории планшеты")
    @Test
    public void test2() {
        SoftAssert softAssert = new SoftAssert();
        YandexSearchPage yandexSearchPage = new YandexSearchPage();
        TabletSubcategoryPage tabletPage = (TabletSubcategoryPage) yandexSearchPage.load()
                .goToMarket()
                .goToCategory("Компьютерная техника")
                .goToTheSubcategory(YandexMarketMainPage.Subcategory.TABLET);

                tabletPage.goToAllFilters()
                .setPrice(20_000, 25_000)
                .selectCompanies("Acer", "DELL")
                .apply();

        softAssert.assertEquals(tabletPage.countElements(), 10);

        String nameFirstElement = tabletPage.getNameElement(0);

        tabletPage.searchElementByName(nameFirstElement);
        softAssert.assertEquals(tabletPage.getNameElement(0), nameFirstElement);

        softAssert.assertAll();
    }
}
