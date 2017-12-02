package com.qatestlab.pages;

import com.qatestlab.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AddProductPage extends NewProductPage {
    Product product = Product.initProduct();
    private By productName = By.id("form_step1_name_1");
    private By productQuantity = By.id("form_step1_qty_0_shortcut");
    private By productPrice = By.id("form_step1_price_shortcut");
    private By productActivateSwitch = By.className("switch-input");
    private By successMessage = By.cssSelector("#growls .growl-notice");
    private By CloseLink = By.className("growl-close");
    private By saveButton = By.cssSelector(".btn.btn-primary.js-btn-save");

    @Test(dependsOnMethods = "clickAddProduct")
    public void fillName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        driver.findElement(productName).sendKeys(product.getName());
    }

    @Test(dependsOnMethods = "fillName")
    public void fillQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity));
        driver.findElement(productQuantity).clear();
        driver.findElement(productQuantity).sendKeys(product.getQuantity());
    }

    @Test(dependsOnMethods = "fillQuantity")
    public void fillPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        driver.findElement(productPrice).clear();
        driver.findElement(productPrice).sendKeys(product.getPrice());
    }

    @Test(dependsOnMethods = "fillPrice")
    public void clickActivateProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productActivateSwitch));
        driver.findElement(productActivateSwitch).click();
    }

    @Test(dependsOnMethods = "clickActivateProduct")
    public void clickCloseMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        driver.findElement(successMessage).findElement(CloseLink).click();
    }

    @Test(dependsOnMethods = "clickCloseMessage")
    public void clickSaveProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
    }
}
