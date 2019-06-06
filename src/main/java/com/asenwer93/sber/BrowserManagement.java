package com.asenwer93.sber;

import com.asenwer93.sber.pages.AbstractPage;

/**
 * Класс управления браузерным окном
 */
public class BrowserManagement extends AbstractPage {
    /**
     * Разворачивает браузер на все окно
     * @return этот объект
     */
    public BrowserManagement windowMaximize(){
        driver.manage().window().maximize();
        return this;
    }


}
