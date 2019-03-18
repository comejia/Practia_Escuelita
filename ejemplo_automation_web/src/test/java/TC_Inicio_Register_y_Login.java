import Helpers.DriverWeb;
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement inicio;
        Assert.assertNotNull(inicio = webDriver.findElement(By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]")));
        Assert.assertEquals(inicio.getText(), "Welcome to the Simple Travel Agency!");


        WebElement button = webDriver.findElement(By.xpath("//div[@class='navbar navbar-inverse']//a[@href='home']"));

        button.click();
        findElement(By.xpath("//*[contains(text(),'Register')]"))
                .click();

        ingresarDatos(webDriver, "name", "Usuario");
        ingresarDatos(webDriver, "company", "compania");
        ingresarDatos(webDriver, "email", "garlompa@server.com");
        ingresarDatos(webDriver, "password", "123123");
        ingresarDatos(webDriver, "password-confirm", "123123");

        webDriver.findElement(By.xpath("//button[text()[contains(.,'Register')]]")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        WebElement loginButton;
        Assert.assertNotNull(loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Login')]"))));
        Assert.assertEquals(loginButton.getText(), "Login");

        ingresarDatos(webDriver, "email", "garlompa@server.com");
        ingresarDatos(webDriver, "password", "123123");

        webDriver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        WebElement loginSuccessful;
        Assert.assertNotNull(loginSuccessful = webDriver.findElement(By.xpath("//div[@class='panel-body'][contains(text(),'You are logged in!')]")));
        Assert.assertEquals(loginSuccessful.getText(), "You are logged in!");
    }

    private void ingresarDatos(WebDriver webDriver, String id, String key)
    {
        webDriver.findElement(By.id(id)).sendKeys(key);
    }
}