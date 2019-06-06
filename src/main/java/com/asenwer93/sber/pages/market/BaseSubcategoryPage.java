package com.asenwer93.sber.pages.market;

import com.asenwer93.sber.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseSubcategoryPage extends AbstractPage {
    protected final String xpathElements = "//div[contains(@class,'n-filter-applied-results__content')]/div[contains(@class,'n-snippet-list')]//div[contains(@class,'n-snippet-card2__title')]/a";

    @FindBy(xpath = "//a/span[text()='Все фильтры']")
    protected WebElement btnAllFilters;

    @FindBy(xpath = "//span[@class='search2__button']//span[text()='Найти']/..")
    protected WebElement btnSearch;

    @FindBy(id = "header-search")
    protected WebElement inputSearch;
}
