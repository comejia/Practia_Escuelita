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

public class PurchaseTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginTest.class));

    protected ExampleSteps exampleSteps;

    @Before
    public void open() throws Exception {
        exampleSteps = new ExampleSteps();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Example: Test case 1 with POM")
    public void test_case_1_POM() throws Exception {

        /*******SETUP********/
        WebDriver webDriver = DriverWeb.getInstance();
        webDriver.get("http://blazedemo.com/");

        String origin = "Paris";
        String destine = "Berlin";
        int opcFlight = 2;
        String monthCard = "05";
        String yearCard = "2000";


        /*********** HOME PAGE***************/
        BlazeDemoHomePage objHomePage;
        objHomePage = new BlazeDemoHomePage(webDriver);
        Assert.assertEquals("Failed to load home page", "Find Flights", objHomePage.getValueBtnFindFlights());
        objHomePage.selectOriginAndDestine(origin, destine);

        /*********** CHOICE fLIGHT ***************/
        BlazeDemoChooseFlight objChoseFlight;
        objChoseFlight = new BlazeDemoChooseFlight(webDriver);
        Assert.assertEquals("Failed to load flights", "Flights from "+ origin + " to " + destine +":", objChoseFlight.getTitleChooseFlightPage());
        objChoseFlight.setChooseFlight(opcFlight);

        /*********** FORM ***************/
        BlazeDemoForm objForm;
        objForm = new BlazeDemoForm(webDriver);
        Assert.assertEquals("Failed to load form page", "Your flight from "+ origin +" to "+ destine +" has been reserved.", objForm.getTitleForm());
        objForm.completeMonthAndYearCard(monthCard, yearCard);


        BlazeDemoData objData;
        objData = new BlazeDemoData(webDriver);
        Assert.assertEquals("Failed to check month and year", monthCard +" /" + yearCard, objData.getCheckData());

    }
}