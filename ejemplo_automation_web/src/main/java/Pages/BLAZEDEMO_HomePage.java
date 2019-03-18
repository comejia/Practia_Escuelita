package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BLAZEDEMO_HomePage {

    WebDriver driver;

    By homeMessage = By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]");

    By homeButton = By.xpath("//div[@class='navbar navbar-inverse']//a[@href='home']");

    public WebElement getHomeMessage()
    {
        return driver.findElement(homeMessage);   //Debería generar excepcion de web element no encontrado?
    }

    public BLAZEDEMO_HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement homeButton()
    {
        return driver.findElement(homeButton);
    }
}
