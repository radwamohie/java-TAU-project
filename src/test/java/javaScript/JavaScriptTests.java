package javaScript;

import base1.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTest {
    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().ScrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScrollPage().scrollToParagraph(5);
    }
}
