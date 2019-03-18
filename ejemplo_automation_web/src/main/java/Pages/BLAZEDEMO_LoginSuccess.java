package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BLAZEDEMO_LoginSuccess {

    WebDriver driver;

    By successAnchor = By.xpath("//div[@class='panel-body'][contains(text(),'You are logged in!')]");

    public BLAZEDEMO_LoginSuccess(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getSuccessMessage()
    {
        return driver.findElement(successAnchor);
    }

}
