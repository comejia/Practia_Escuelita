import Helpers.DriverWeb;
import example.pages.*;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import example.pages.content.PurchaseFormData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Test.BaseTest;

public class PurchaseFlightTest extends BaseTest {

    @Test
    public void test_purchaseFlight_firstFlightOption_OK()  throws Exception {

        // Open Browser
        WebDriver webDriver = DriverWeb.getInstance();
        webDriver.get("http://Blazedemo.com/");

        BlazeDemo_HomePage homePage;
        homePage = new BlazeDemo_HomePage(webDriver);
        Assert.assertEquals("Failed to load home page", "Find Flights", homePage.getValueBtnFindFlights());

        homePage.setOriginChoose(FlightsOrigin.PARIS);
        homePage.setDestineChoose(FlightsDestination.CAIRO);
        homePage.clickFindFlights();

        //TODO: llegar al POM todos los findelement, pedirle al POM el string o el dato para el assert
        BlazeDemo_ChooseFlight chooseFlightPage = new BlazeDemo_ChooseFlight(webDriver);
        Assert.assertEquals("Could not found flights","Flights from Paris to Cairo: ",chooseFlightPage.getTitleChooseFlightPage());
        chooseFlightPage.setChooseFlight(FlightOptions.ONE.getFlightOptions());

        BlazeDemo_Form purchasePage = new BlazeDemo_Form(webDriver);
        Assert.assertEquals("Could not reserve flight","Your flight from Paris to Cairo has been reserved.",purchasePage.getTitleForm());

        PurchaseFormData client = new PurchaseFormData("Cesar", "Balvanera", "Buenos Aires", "Buenos Aires", "1081", "1234567891234", "11", "2020", "Cesar Castro");
        purchasePage.completeForm(client);
        purchasePage.purchaseFlight();

        // Go the next page
        BlazeDemo_ConfirmationPage confirmationPage = new BlazeDemo_ConfirmationPage(webDriver);

        Assert.assertEquals("Could not buy flight","Thank you for your purchase today!",confirmationPage.getMessage());

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Example: Test case 1 with POM")
    public void test_purchaseFlight_secondFlightOption_OK() throws Exception {

        /*******SETUP********/
        WebDriver webDriver = DriverWeb.getInstance();
        webDriver.get("http://blazedemo.com/");

        FlightsOrigin origin = FlightsOrigin.PARIS;
        FlightsDestination destine = FlightsDestination.BERLIN;
        int opcFlight = 2;
        String monthCard = "05";
        String yearCard = "2000";


        /*********** HOME PAGE***************/
        BlazeDemo_HomePage objHomePage;
        objHomePage = new BlazeDemo_HomePage(webDriver);
        Assert.assertEquals("Failed to load home page", "Find Flights", objHomePage.getValueBtnFindFlights());
        objHomePage.selectOriginAndDestine(origin, destine);

        /*********** CHOICE fLIGHT ***************/
        BlazeDemo_ChooseFlight objChoseFlight;
        objChoseFlight = new BlazeDemo_ChooseFlight(webDriver);
        Assert.assertEquals("Failed to load flights", "Flights from "+ origin + " to " + destine +":", objChoseFlight.getTitleChooseFlightPage());
        objChoseFlight.setChooseFlight(opcFlight);

        /*********** FORM ***************/
        BlazeDemo_Form objForm;
        objForm = new BlazeDemo_Form(webDriver);
        Assert.assertEquals("Failed to load form page", "Your flight from "+ origin +" to "+ destine +" has been reserved.", objForm.getTitleForm());
        objForm.completeMonthAndYearCard(monthCard, yearCard);


        BlazeDemo_ConfirmationPage objData;
        objData = new BlazeDemo_ConfirmationPage(webDriver);
        Assert.assertEquals("Failed to check month and year", monthCard +" /" + yearCard, objData.getCheckData());

    }

}
