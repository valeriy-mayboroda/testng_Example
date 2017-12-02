package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by val on 02.12.2017.
 */
public class ShopProductPage extends ShopSearchResultsPage {
    private By productPrice = By.cssSelector(".product-prices .product-price .current-price");
    private By productQuantity = By.cssSelector(".product-quantities span");
    private By productName = By.cssSelector("h1[itemprop=name]");

    @Test(dependsOnMethods = "checkNotNullAndOpenProduct")
    public void checkProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        Assert.assertEquals(product.getName(), driver.findElement(productName).getText().toLowerCase(), "The product shop's name is not equals the product's name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity));
        Assert.assertEquals(product.getQuantity(), driver.findElement(productQuantity).getText().split(" ")[0], "The product shop's quantity is not equals the product's quantity");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        Assert.assertEquals(product.getPrice(), driver.findElement(productPrice).getText().split(" ")[0], "The product shop's price is not equals the product's price");
    }
}
