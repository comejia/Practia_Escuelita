import Helpers.DriverWeb;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

import javax.print.attribute.standard.Finishings;
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
        webDriver.get("http://BlazedemoPage.com/");
        Thread.sleep(3000);
        findElement(By.xpath("//body//input[@value='Find Flights']"));
        WebElement button = findElement(By.xpath("//body//input[@value='Find Flights']"));
        button.click();





    }

}
