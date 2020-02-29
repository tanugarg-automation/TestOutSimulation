package org.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.test.pageObjects.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimulationTest extends TestBase {
    public static final String PERFECT_SCORE = "1 of 1 (100%)";
    private WebDriver driver;
    private SimulationIpad simulationIpad;

    @Before
    public void setUp() {
        driver = getWebDriver();
        driver.get(baseUrl);
        simulationIpad = new SimulationIpad(driver);
    }

    @Test
    public void testSSLandPort(){
        /*
        a.    Select Settings.
        b.    Select Mail, Contacts, Calendars.
        c.    Select Maggie Brown.
        d.    Select mbrown@gmail.com.
        e.    Select Advanced.
        f.    Slide the button to enable Use SSL.
        g.    Verify that the server port is set to 993.
        h.    At the top, select Account.
        i.    Click Done.
        */

        IpadSettings iPadSettings = simulationIpad.clickSettings();
        SettingsRightPanel settingsRightPanel = iPadSettings.clickMailContactCalendars();
        AccountDetails accountDetails = settingsRightPanel.clickUserAccount();
        AdvancedSettings advancedSettings = accountDetails.selectAdvanced();
        advancedSettings.useSSL();
        assertEquals("Incorrect server port on using SSL", "993", advancedSettings.getPort());
        accountDetails = advancedSettings.exitAdvancedSettings();
        accountDetails.selectDone();


      /*  Connect to CorpNet-Wireless Wi-Fi as follows:
        a.    Click Wi-Fi.
        b.    Click CorpNet.
        c.     In the Password field, enter @CorpNetWeRSecure!& as the password.
        d.    Click Join.*/

        WiFiSettings wiFiSettings = settingsRightPanel.selectWifi();
        PasswordForm passwordForm = wiFiSettings.selectCorpNet();
        passwordForm.enterPassword("@CorpNetWeRSecure!&");
        simulationIpad.clickDone();
        //switch to iFrame and check Results
        LabReport labReport = new LabReport(driver);
        String actualScore = labReport.getScore();
        assertTrue("Incorrect score. Expected :" +  PERFECT_SCORE + "Actual: "
                + actualScore, actualScore.contains(PERFECT_SCORE));
    }
}