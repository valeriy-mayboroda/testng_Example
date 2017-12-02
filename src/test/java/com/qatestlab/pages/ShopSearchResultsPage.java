package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ShopSearchResultsPage extends ShopSearchProductsPage {
    private By searchResults = By.cssSelector(".product-description .h3.product-title");
    private WebElement resultProduct;

    @Test(dependsOnMethods = "searchProduct")
    public void checkNotNullAndOpenProduct() {
        resultProduct = findProduct();
        Assert.assertNotNull(resultProduct, "The product is absent in the shop");
        resultProduct.click();
    }

    public WebElement findProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResults));
        List<WebElement> list = driver.findElements(searchResults);
        for(WebElement webElement: list) {
            if (webElement.getText().toLowerCase().equals(product.getName())) {
                return webElement;
            }
        }
        return null;
    }
}
