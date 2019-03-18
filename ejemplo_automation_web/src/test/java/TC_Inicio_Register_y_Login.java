import Helpers.DriverWeb;
import Pages.BLAZEDEMO_HomePage;
import Pages.BLAZEDEMO_Login;
import Pages.BLAZEDEMO_Register;
import Pages.BLAZEDEMO_LoginSuccess;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import example.testSteps.ExampleSteps;
import Test.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class TC_Inicio_Register_y_Login extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginTest.class));

    protected ExampleSteps exampleSteps;

    @Before
    public void open() {
        exampleSteps = new ExampleSteps();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Example: Test case name")
    public void test() {


        WebDriver webDriver = DriverWeb.getInstance();
        webDriver.get("http://blazedemo.com/");
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        BLAZEDEMO_HomePage homePage = new BLAZEDEMO_HomePage(webDriver);
        BLAZEDEMO_Login loginPage = new BLAZEDEMO_Login(webDriver);
        BLAZEDEMO_LoginSuccess loginSuccessPage = new BLAZEDEMO_LoginSuccess(webDriver);
        BLAZEDEMO_Register registerPage = new BLAZEDEMO_Register(webDriver);

        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        //Assert.assertNotNull(loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Login')]"))));

        Assert.assertEquals(homePage.getHomeMessage().getText(), "Welcome to the Simple Travel Agency!");

        wait.until(ExpectedConditions.elementToBeClickable(homePage.homeButton())).click();

        loginPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getRegisterAnchor().getText(),"Register");

        registerPage.registerToBlazeDemo("Usuario", "compania", "garlompa@server.com", "123123", "123123");

        registerPage.clickRegisterButton();

        //Assert.assertNotNull(loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Login')]"))));
        Assert.assertEquals(loginPage.getLoginAnchor().getText(), "Login");

        loginPage.loginToBlazeDemo("garlompa@server.com","123123");

        //Assert.assertNotNull(loginSuccessful = webDriver.findElement(By.xpath("//div[@class='panel-body'][contains(text(),'You are logged in!')]")));
        Assert.assertEquals(loginSuccessPage.getSuccessMessage().getText(), "You are logged in!");
    }
}