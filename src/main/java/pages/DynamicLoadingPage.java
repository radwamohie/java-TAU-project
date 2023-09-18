package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
    private String linkpath_Format = "//*[@id=\"content\"]/div/a[1]";
    private By link_Example1 = By.xpath(String.format(linkpath_Format,"Example 1"));


    public DynamicLoadingPage(WebDriver driver){
        this.driver=driver;
    }
    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }


}
