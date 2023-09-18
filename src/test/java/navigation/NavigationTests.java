package navigation;

import base1.BaseTest;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {
@Test
public void testNavigator(){
    homePage.clickDynamicLoading().clickExample1();
    getWindowManager().goBack();
    getWindowManager().refreshPage();
    getWindowManager().goForward();
    getWindowManager().goTo("https://google.com");

}

@Test
    public void testSwitchTab(){
    homePage.clickMultipleWindows().clickHere();
    getWindowManager().switchToTab("New Window");
}


}
