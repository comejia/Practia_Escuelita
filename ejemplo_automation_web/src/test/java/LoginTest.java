import Helpers.DriverWeb;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import example.testSteps.ExampleSteps;
import Test.BaseTest;

import java.util.logging.Logger;

public class LoginTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginTest.class));

    protected ExampleSteps exampleSteps;

    @Before
    public void open() throws Exception {
        exampleSteps = new ExampleSteps();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Example: Test case name")
    public void test() throws Exception {


        WebDriver webDriver = DriverWeb.getInstance();
        webDriver.get("http://blazedemo.com/");
        Thread.sleep(3000);
        findElement(By.xpath("//body//input[@value='Find Flights']"));
        WebElement button = findElement(By.xpath("//body//input[@value='Find Flights']"));
        button.click();


    }

}
