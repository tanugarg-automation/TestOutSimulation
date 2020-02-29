package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ComponentBase {

    private WebDriver driver;
    private PageFactory pageFactory;
    private Wait wait;
    private Actions actions;

    public ComponentBase(WebDriver driver) {
        this.driver = driver;
        this.pageFactory = new PageFactory();
        this.wait = new WebDriverWait(driver, 5);
        this.actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageFactory getPageFactory() {
        return pageFactory;
    }

    public Wait getWait() {
        return wait;
    }

    public Actions getActions() {
        return actions;
    }

    public WebElement findElementByWait(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public void waitForSlide(int timeOut){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        wait.withTimeout(timeOut, TimeUnit.MILLISECONDS);
    }

}
