package com.asenwer93.sber.pages;

import com.asenwer93.sber.pages.market.YandexMarketMainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Главная страница яндекса и переход в яндекс маркет
 */
public class YandexSearchPage extends AbstractPage {
    private WebDriverWait wait;
    private String URL = "http://yandex.ru";

    @FindBy(xpath = "//a[@data-id='market']")
    private WebElement market;

    public YandexSearchPage(){
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Загрузка главной страницы яндекса
     * @return этот объект
     */
    public YandexSearchPage load(){
        driver.navigate().to(URL);

        return this;
    }

    /**
     * Перейти в маркет
     * @return этот объект
     */
    public YandexMarketMainPage goToMarket(){
        wait.until(ExpectedConditions.elementToBeClickable(market)).click();

        return new YandexMarketMainPage();
    }
}
