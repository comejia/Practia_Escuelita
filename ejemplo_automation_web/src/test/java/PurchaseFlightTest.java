import Helpers.DriverWeb;
import example.pages.BlazedemoPage;
import example.pages.BlazedemoConfirmationPage;
import example.pages.BlazedemoPurchasePage;
import example.pages.BlazedemoReservePage;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsDestiny;
import example.pages.content.FlightsOrigin;
import example.pages.content.PurchaseFormData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Test.BaseTest;

public class PurchaseFlightTest extends BaseTest {


    @Test
    public void tc2_purchase_flight_ok()  throws Exception {

    // Open Browser
    WebDriver web = DriverWeb.getInstance();
    web.get("http://Blazedemo.com/");
    BlazedemoPage blaze = new BlazedemoPage();

    // Verify the home page
    Assert.assertNotNull("Page not found", findElement(By.xpath("//body//input[@value='Find Flights']"), 2, false));


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
    res.choseFlight(FlightOptions.ONE);

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
}
