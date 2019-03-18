import Helpers.DriverWeb;
import example.pages.BlazeDemoData;
import example.pages.BlazeDemoForm;
import example.pages.BlazeDemoHomePage;
import example.pages.BlazeDemoChooseFlight;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
    @DisplayName("Example: Test case 1")
    public void test() throws Exception
    {
        WebDriver webDriver = DriverWeb.getInstance();
        webDriver.get("http://blazedemo.com/");

    }
}
