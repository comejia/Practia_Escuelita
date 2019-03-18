import Helpers.DriverWeb;
import example.pages.*;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsDestiny;
import example.pages.content.FlightsOrigin;
import example.pages.content.PurchaseFormData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Test.BaseTest;

public class PurchaseFlightTest extends BaseTest {

    @Test
    public void test_purchaseFlight_firstFlightOption_OK()  throws Exception {

    // Open Browser
    WebDriver web = DriverWeb.getInstance();
    web.get("http://Blazedemo.com/");

    // Verify the home page
    Assert.assertNotNull("Page not found", findElement(By.xpath("//body//input[@value='Find Flights']"), 2, false));

    BlazedemoPage blaze = new BlazedemoPage();
    // Input origin and destination
    blaze.setOrigen(FlightsOrigin.PARIS);
    blaze.setDestino(FlightsDestiny.CAIRO);

    // Push button [Find Flights]
    blaze.findFlights();

    // Go the next page
    BlazedemoReservePage res = new BlazedemoReservePage();

    // Verify if find flight
    Assert.assertNotNull("Could not found flights", findElement(By.xpath("//h3[contains(text(),'Flights')]"), 2, false));

    // Push button of first flight
    res.choseFlight(FlightOptions.ONE.getFlightOptions());
    // Go the next page
    BlazedemoPurchasePage pur = new BlazedemoPurchasePage();

    // Verify if flight was reserved
    Assert.assertNotNull("Could not reserve flight", findElement(By.xpath("//h2[contains(text(),'Your flight from Paris to Cairo has been reserved')]"), 5, false));

    // Completed form
    PurchaseFormData client = new PurchaseFormData("Cesar", "Balvanera", "Buenos Aires", "Buenos Aires", "1081", "1234567891234", "11", "2020", "Cesar Castro");
    pur.completeForm(client);

    // Push button of Purchase flight
    pur.purchaseFlight();

    // Go the next page
    BlazedemoConfirmationPage conf = new BlazedemoConfirmationPage();

    // Verify if flight was bought
    Assert.assertNotNull("Could not reserve flight", findElement(By.xpath("//h1[contains(text(),'Thank you')]"), 5, false));

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Example: Test case 1 with POM")
    public void test_purchaseFlight_secondFlightOption_OK() throws Exception {

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
