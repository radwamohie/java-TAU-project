package login;

import base1.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfullLogin(){
       LoginPage loginPage= homePage.clickFormAuthentication();
       loginPage.setUsernameField("tomsmith");
       loginPage.setPasswordField("SuperSecretPassword!");
       SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
       assertTrue(secureAreaPage.getAlertText()
                       .contains("You logged into a secure area!")
                       ,"Alert text incorrect");
    }
}
