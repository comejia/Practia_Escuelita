package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BLAZEDEMO_Register {

    WebDriver driver;

    By nameField = By.id("name");
    By companyField = By.id("company");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirm");
    By registerButton = By.xpath("//button[text()[contains(.,'Register')]]");
    By registerAnchor = By.xpath("//div[@class='panel-heading'][contains(text(), 'Register')]");

    public BLAZEDEMO_Register(WebDriver driver)
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
        clickRegisterButton();
    }

    public void clickRegisterButton()
    {
        driver.findElement(registerButton).click();
    }

    public WebElement getRegisterAnchor()
    {
        return driver.findElement(registerAnchor);
    }
}
