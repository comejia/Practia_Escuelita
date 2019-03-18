package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BlazeDemo_Login extends WebComponent {

    WebDriver driver;

    By registerButton = By.xpath("//*[contains(text(),'Register')]");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    public By loginAnchor = By.xpath("//div[contains(text(),'Login')]");

    public BlazeDemo_Login(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickRegisterButton()
    {
        driver.findElement(registerButton).click();
    }

    private void setEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    private void setPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton()
    {
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }

    public WebElement getLoginAnchor (){
        return driver.findElement(loginAnchor);
    }

    public void loginToBlazeDemo(String email, String password)
    {
        this.setEmail(email);
        this.setPassword(password);
    }
}
