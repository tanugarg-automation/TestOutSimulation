package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.test.pageObjects.ComponentBase;

public class LabReport extends ComponentBase {

    private WebElement frameElement = getDriver().findElements(By.tagName("iframe")).get(1);

    private By scoreElement = By.cssSelector(".clsBox2");


    public LabReport(WebDriver driver) {
        super(driver);
    }


    public String getScore() {
        getDriver().switchTo().frame(frameElement);
        return getDriver().findElement(scoreElement).getText();
    }
}
