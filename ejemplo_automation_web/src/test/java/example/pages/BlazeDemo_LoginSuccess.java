package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BlazeDemo_LoginSuccess extends WebComponent {

    WebDriver driver;

    public By successMessage = By.xpath("//div[@class='panel-body'][contains(text(),'You are logged in!')]");

    public BlazeDemo_LoginSuccess(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getSuccessMessage()
    {
        return driver.findElement(successMessage);
    }

}
