package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SettingsRightPanel extends ComponentBase{

    private By userSubMenuBy = By.cssSelector("#gClient [data-typename='SettingsItemSubMenu']");
    private By userBy = By.cssSelector("#siAccount #siAccount\\.Grid\\.rectClickArea");
    private By wifiBy = By.cssSelector("#siWiFi");

    public SettingsRightPanel(WebDriver driver) {
        super(driver);
    }

    public AccountDetails clickUserAccount() {
        WebElement userSubMenuElement = findElementByWait(userSubMenuBy, 2000);
        userSubMenuElement.click();
        WebElement userElement = findElementByWait(userBy, 2000);
        userElement.click();
        return getPageFactory().initElements(getDriver(), AccountDetails.class);
    }

    public WiFiSettings selectWifi() {
        getDriver().findElement(wifiBy).click();
        return getPageFactory().initElements(getDriver(), WiFiSettings.class);
    }
}
