package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea =By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("button[title='Decrease indent']");


    public EditorPage (WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void SetTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
       String text= driver.findElement(textArea).getText();
       switchToMainArea();
       return text;
    }






}
