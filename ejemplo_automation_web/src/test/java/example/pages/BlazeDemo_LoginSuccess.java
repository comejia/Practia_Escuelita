package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BlazeDemo_LoginSuccess extends WebComponent {

    public By successMessage = By.xpath("//div[@class='panel-body'][contains(text(),'You are logged in!')]");

    public WebElement getSuccessMessage()
    {
        return getDriver().findElement(successMessage);
    }

}
