package org.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IpadSettings extends ComponentBase{

    private By  mailContactCalendarsElementBy = By.cssSelector("#siMailContactsCalendars");

    public IpadSettings(WebDriver driver) {
        super(driver);
    }


    public SettingsRightPanel clickMailContactCalendars() {
        WebElement mailContactCalendarsElement = findElementByWait(mailContactCalendarsElementBy, 1000);
        mailContactCalendarsElement.click();
        return getPageFactory().initElements(getDriver(), SettingsRightPanel.class);
    }
}
