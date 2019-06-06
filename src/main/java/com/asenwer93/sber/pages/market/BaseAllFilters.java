package com.asenwer93.sber.pages.market;

import com.asenwer93.sber.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAllFilters extends AbstractPage {
    @FindBy(id = "glf-pricefrom-var")
    protected WebElement fromPrice;

    @FindBy(id = "glf-priceto-var")
    protected WebElement toPrice;

    @FindBy(xpath = "//div[contains(@data-filter-id,'7893318')]//span[text()='Показать всё']/..")
    protected WebElement openAllCompany;

    @FindBy(xpath = "//div[contains(@data-filter-id,'7893318')]//input[contains(@class,'input__control')]")
    protected WebElement inputSearchCompany;

    @FindBy(xpath = "//a/span[text()='Показать подходящие']")
    protected WebElement apply;

    protected final String xpathCheckboxSelectionForCompany =
            ".//span[contains(@class,'checkbox')]//label[text()='%s']/..//input";

    public BaseAllFilters setPrice(int min, int max) {
        fromPrice.sendKeys(Integer.toString(min));
        toPrice.sendKeys(Integer.toString(max));

        return this;
    }

    public BaseAllFilters selectCompanies(String... companies) {
        wait = new WebDriverWait(driver, 30);
        openAllCompany.click();
        for (String company : companies) {
            inputSearchCompany.clear();
            inputSearchCompany.sendKeys(company);
            // чекбокс не нажимается без ожидания, даже если этот элемент
            // уже присутствует
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    String.format(xpathCheckboxSelectionForCompany, company)
            )));

            WebElement element = driver.findElement(By.xpath(String.format(xpathCheckboxSelectionForCompany, company)));
            Actions actions = new Actions(driver);

            actions.moveToElement(element).click().perform();
        }

        return this;
    }

    public BaseSubcategoryPage apply() {
        Actions actions = new Actions(driver);

        actions.moveToElement(apply).click().perform();

        return new BaseSubcategoryPage();
    }
}
