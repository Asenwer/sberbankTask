package com.asenwer93.sber.pages.market.tablets;

import com.asenwer93.sber.pages.market.BaseSubcategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class TabletSubcategoryPage extends BaseSubcategoryPage {
    /**
     * Во время поиска по имени может открыть страницу с этим товаром,
     * а может список товаров, если есть несколько комплектаций(как с ноутами)
     */
    private final String xpathElements = super.xpathElements + " | " +
            "//div[contains(@class,'n-title__text')]/h1";

    public TabletAllFilters goToAllFilters() {
        btnAllFilters.click();

        return new TabletAllFilters();
    }

    public int countElements() {
        List<WebElement> elements = driver.findElements(By.xpath(xpathElements));

        return elements.size();
    }

    public String getNameElement(int index) {
        List<WebElement> elements = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(xpathElements)))
                .findElements(By.xpath(xpathElements));

        return elements.get(index).getText();
    }

    public TabletSubcategoryPage searchElementByName(String name) {
        inputSearch.sendKeys(name);
        btnSearch.click();

        return this;
    }
}
