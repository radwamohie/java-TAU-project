package frames;

import base1.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTest {
    @Test
    public void testEditor(){
        var editorPage =homePage.clickEditor();
        editorPage.clearTextArea();
        String text1 = "hello";
        String text2 = "world";
        editorPage.SetTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.SetTextArea(text2);
        assertEquals(editorPage.getTextFromEditor(),text1+text2,"incorrect message");
    }
}
