package alerts;

import base1.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTest {
    @Test

    public void testAcceptAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerAlert();
        alertPage.alert_clickToAcceptAlert();
        assertEquals(alertPage.getResult(),
                "You successfully clicked an alert" ,
                "results incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerConfirmAlert();
        String text= alertPage.alert_getText();
        alertPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm","incorrect alert text");

    }

    @Test
    public void testSetInputInAlert(){
        var alertPage =homePage.clickJavaScriptAlerts();
        alertPage.triggerPrompt();
        String text = "TAU great";
        alertPage.alert_SetInput(text);
        alertPage.alert_clickToAcceptAlert();
        assertEquals(alertPage.getResult(),"You entered: "+text,"Results text incorrect");
    }
}
