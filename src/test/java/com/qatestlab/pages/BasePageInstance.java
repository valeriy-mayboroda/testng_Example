package com.qatestlab.pages;

import com.qatestlab.event.EventHandlerInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BasePageInstance {
    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;

    public WebDriver getDriver(String browser) {
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            return new FirefoxDriver();
        }
        if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
            return new InternetExplorerDriver();
        }

        else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            return new ChromeDriver();
        }
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        WebDriver webDriver = getDriver(browser);
        driver = new EventFiringWebDriver(webDriver);
        driver.register(new EventHandlerInstance());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    @BeforeClass
    public void setWait(){wait = new WebDriverWait(driver, 15);}

    @AfterClass
    public void closeDriverWait() {
        if (wait != null)
            wait = null;
    }
}
