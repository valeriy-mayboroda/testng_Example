package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPage extends BasePageInstance {
    private By login = By.id("email");
    private By password = By.id("passwd");
    private By loginButton = By.name("submitLogin");

    @DataProvider
    public Object[][] getLoginData() {
        return new String[][]{
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }

    @Test
    @Parameters({"url"})
    public void openUrl(String url) {driver.get(url);}

    @Test (dependsOnMethods = "openUrl", dataProvider = "getLoginData")
    public void fillLoginData(String emailExample, String passwordExample) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(login));
        driver.findElement(login).sendKeys(emailExample);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys(passwordExample);
    }

    @Test (dependsOnMethods = "fillLoginData")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }
}