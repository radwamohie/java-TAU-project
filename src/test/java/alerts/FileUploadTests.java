package alerts;

import base1.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTest {
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\radwa\\IdeaProjects\\Selenium\\src\\main\\resources\\cheat_sheet.jfif");
        uploadPage.clickUploadButton();
        assertEquals(uploadPage.getUploadedFiles(),"cheat_sheet.jfif","incorrect uploaded file");

    }
}
