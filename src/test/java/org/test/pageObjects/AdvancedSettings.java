package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedSettings extends ComponentBase{

    private By portBy = By.cssSelector("#tbServerPort");
    private By exitBy = By.cssSelector("#btnAccount");
    private By sslSliderBy = By.cssSelector("#siUseSSL\\.Grid\\.tbOnOff");

    public AdvancedSettings(WebDriver driver) {
        super(driver);
    }


    public void useSSL() {
        WebElement sslSlider = findElementByWait(sslSliderBy, 1000);
        getActions().dragAndDropBy(sslSlider,40,0).perform();
    }

    public String getPort() {
        WebElement element = getDriver().findElement(portBy);
        return element.getAttribute("value");
    }

    public AccountDetails exitAdvancedSettings() {
        WebElement exitElement = findElementByWait(exitBy, 1000);
        exitElement.click();
        return getPageFactory().initElements(getDriver(), AccountDetails.class);
    }
}
