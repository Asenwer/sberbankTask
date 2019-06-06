package com.asenwer93.sber.pages.market.laptop;

import com.asenwer93.sber.pages.market.BaseSubcategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LaptopSubcategoryPage extends BaseSubcategoryPage {

    public LaptopAllFilters goToAllFilters() {
        btnAllFilters.click();

        return new LaptopAllFilters();
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

    public LaptopSubcategoryPage searchElementByName(String name) {
        inputSearch.sendKeys(name);
        btnSearch.click();

        return this;
    }
}
