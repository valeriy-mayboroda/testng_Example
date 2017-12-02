package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ProductPage extends LoginPage {
    private By menuCatalog = By.id("subtab-AdminCatalog");
    private By menuCatalogProducts = By.id("subtab-AdminProducts");
    private By link = By.tagName("a");

    @Test(dependsOnMethods = "clickLoginButton")
    public void clickCatalogProductItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuCatalog));
        WebElement catalogIcon = driver.findElement(menuCatalog);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogIcon).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuCatalogProducts));
        catalogIcon.findElement(menuCatalogProducts).findElement(link).click();
    }
}
