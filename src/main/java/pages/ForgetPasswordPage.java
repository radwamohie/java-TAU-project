package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage {
    private WebDriver driver;
    private By emailfield = By.id("email");
    private By RetrievePasswordButton = By.id("form_submit");


    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterEmail(String email) {
        driver.findElement(emailfield).sendKeys(email);
    }

    public EmailSentPage clickRetrievePasswordButton() {
        driver.findElement(RetrievePasswordButton).click();
        return new EmailSentPage(driver);
    }

    public EmailSentPage retrievePassword(String email){
        EnterEmail(email);
        return clickRetrievePasswordButton();
    }

}
