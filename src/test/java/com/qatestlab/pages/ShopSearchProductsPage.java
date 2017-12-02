package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ShopSearchProductsPage extends ShopMainPage {
    private By productSearchInput = By.className("ui-autocomplete-input");
    private By productSearchButton = By.cssSelector("#search_widget button[type=submit]");

    @Test(dependsOnMethods = "clickAllProductsLink")
    public void searchProduct () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSearchInput));
        driver.findElement(productSearchInput).sendKeys(product.getName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSearchButton));
        driver.findElement(productSearchButton).click();
    }
}
