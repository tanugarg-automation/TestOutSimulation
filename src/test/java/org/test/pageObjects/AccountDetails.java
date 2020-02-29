package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetails extends ComponentBase{

    @FindBy(css= ".clsFrameworkElement [data-typename='ScrollViewer']")
    private By advancedBy = By.cssSelector("div[id$='spAccount\\.PropertyGroup2']");
    private By doneBy = By.cssSelector("div[id$='btnDone']");

    public AccountDetails(WebDriver driver) {
        super(driver);
    }

    public AdvancedSettings selectAdvanced() {
        WebElement advancedElement = findElementByWait(advancedBy, 1000);
        advancedElement.click();
        return getPageFactory().initElements(getDriver(), AdvancedSettings.class);
    }

    public void selectDone() {
        WebElement doneElement = findElementByWait(doneBy, 1000);
        doneElement.click();
    }
}
