package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BlazeDemo_Register extends WebComponent {

    WebDriver driver;

    By nameField = By.id("name");
    By companyField = By.id("company");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirm");
    By registerButton = By.xpath("//button[text()[contains(.,'Register')]]");
    public By registerAnchor = By.xpath("//div[@class='panel-heading'][contains(text(), 'Register')]");

    public BlazeDemo_Register(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setName(String name)
    {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setEmailField(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setCompanyField(String company)
    {
        driver.findElement(companyField).sendKeys(company);
    }
    public void setPasswordField(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void setConfirmPasswordField(String confirmPassword)
    {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void registerToBlazeDemo(String name,String company,String email,String password, String confirmPassword){
        setName(name);
        setCompanyField(company);
        setEmailField(email);
        setPasswordField(password);
        setConfirmPasswordField(confirmPassword);
    }

    public void clickRegisterButton()
    {
        driver.findElement(registerButton).click();
    }

    public String getRegisterAnchor()
    {
        return driver.findElement(registerAnchor).getText();
    }
}
