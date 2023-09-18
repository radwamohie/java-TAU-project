package base1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
      System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
      driver=new ChromeDriver(getChromeOptions());

      //driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
      //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      goHome();
      setCookie();

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(),
                        new File("src/main/resources/screenshots/"+result.getName()+".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public WindowManger getWindowManager(){
        return new WindowManger(driver);
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new  ChromeOptions();
        options.addArguments("disable=infobars");
        //options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie =new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

}
