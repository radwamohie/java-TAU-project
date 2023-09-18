package keys;

import base1.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressersPage;

import static org.testng.Assert.assertEquals;

public class KeysTest extends BaseTest {

    @Test
    public void testBackspace(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(),"You entered: BACK_SPACE");
    }
    @Test
    public void testPi(){
        var keyPage=homePage.clickKeyPresses();
        keyPage.enterChar();
    }
}
