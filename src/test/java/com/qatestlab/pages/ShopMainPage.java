package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShopMainPage extends AddProductPage {
    private By productsLink = By.className("all-product-link");

    @Test(dependsOnMethods = "clickSaveProduct")
    @Parameters({"shopUrl"})
    public void openShopUrl(String url) {driver.get(url);}

    @Test(dependsOnMethods = "openShopUrl")
    public void clickAllProductsLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsLink));
        driver.findElement(productsLink).click();
    }
}
