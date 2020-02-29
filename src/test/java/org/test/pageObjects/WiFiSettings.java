package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WiFiSettings extends ComponentBase{

    private By corpNetBy = By.cssSelector("#SettingsItemNetwork");

    public WiFiSettings(WebDriver driver) {
        super(driver);
    }

    public PasswordForm selectCorpNet() {
        getDriver().findElement(corpNetBy).click();
        return getPageFactory().initElements(getDriver(), PasswordForm.class);
    }
}
