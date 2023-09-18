package forgetPassword;

import base1.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgetPassword extends BaseTest {
    @Test
    public void testRetrievePassword(){
        var ForgetPasswordPage = homePage.clickRetrievePasswordButton();
        var EmailSentpage = ForgetPasswordPage.retrievePassword("tau@example.com");

        assertEquals(EmailSentpage.getMessage(),
                "Your e-mail's been sent!",
                "Message is incorrect");

    }
}
