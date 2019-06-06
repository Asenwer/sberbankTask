package com.asenwer93.sber.pages;

import com.asenwer93.sber.helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Абсрактный класс для расширения страниц. Инициализирует драйвер и элементы через @FindBy
 */
public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    /**
     * Дефолтный конструктор. Получаем драйвер для взаимодействия с ним,
     * а так же инициализируем элементы на Page'ах, которые были заданы с помощью аннотаций @FindBy
     */
    public AbstractPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, 30);
    }
}