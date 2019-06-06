package com.asenwer93.sber.pages.market;

import com.asenwer93.sber.pages.AbstractPage;
import com.asenwer93.sber.pages.market.laptop.LaptopSubcategoryPage;
import com.asenwer93.sber.pages.market.tablets.TabletSubcategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Главная страница яндекс маркета.
 * Реализован переход к указанной категории и подкатегории
 */
public class YandexMarketMainPage extends AbstractPage {
    public enum Subcategory {
        LAPTOP("Ноутбуки"),
        TABLET("Планшеты");

        private String name;

        Subcategory(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return name;
        }
    }

    private final String categoryItems = "//div[@class='n-w-tab n-w-tab_type_navigation-menu']/a[contains(@data-bem, '\"name\":\"%s\"')]";
    private final String subcategoryItems = "//div[@data-zone-name='link']/a[text()='%s']";


    /**
     * Выбрать категорию
     * @param category имя категории
     * @return этот объект
     */
    public YandexMarketMainPage goToCategory(String category){
        WebElement element = driver.findElement(By.xpath(String.format(categoryItems, category)));
        element.click();

        return this;
    }

    /**
     * Выбрать подкатегорию
     * @param subcategory имя подкатегории
     * @return этот объект
     */
    public BaseSubcategoryPage goToTheSubcategory(Subcategory subcategory){
        driver.findElement(By.xpath(String.format(subcategoryItems, subcategory)))
                .click();
        switch (subcategory) {
            case LAPTOP:
                return new LaptopSubcategoryPage();
            case TABLET:
                return new TabletSubcategoryPage();
        }
        return null;
    }
}
