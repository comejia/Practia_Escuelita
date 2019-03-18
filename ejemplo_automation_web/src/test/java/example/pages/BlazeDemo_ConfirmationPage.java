package example.pages;

import Test.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemo_ConfirmationPage extends BaseTest {

    WebDriver driver;
    By checkData = By.xpath("//body//tr[5]//td[2]");
    By message = By.xpath("//h1[contains(text(),'Thank you')]");


    public BlazeDemo_ConfirmationPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public String getCheckData()
    {
        return driver.findElement(checkData).getText();

    }

    public String getMessage()
    {
        return  driver.findElement(message).getText();
    }
}