package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class NewProductPage extends ProductPage {
    private By addProduct = By.id("page-header-desc-configuration-add");

    @Test(dependsOnMethods = "clickCatalogProductItem")
    public void clickAddProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addProduct));
        driver.findElement(addProduct).click();
    }
}
