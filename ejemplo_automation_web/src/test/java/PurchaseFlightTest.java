import Helpers.DriverWeb;
import example.pages.BlazedemoPage;
import example.pages.BlazedemoConfirmationPage;
import example.pages.BlazedemoPurchasePage;
import example.pages.BlazedemoReservePage;
import example.pages.content.FlightsDestiny;
import example.pages.content.FlightsOrigin;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PurchaseFlightTest {


@Test
    public void tc2_purchase_flight_ok()  throws Exception {

    // Open Browser
    WebDriver web = DriverWeb.getInstance();
    web.get("http://BlazedemoPage.com/");
    BlazedemoPage blaze = new BlazedemoPage();

    // Verify the home page
    blaze.homePage();

    // Input origin and destination
    blaze.setOrigen(FlightsOrigin.PARIS);
    blaze.setDestino(FlightsDestiny.CAIRO);

    // Push button [Find Flights]
    blaze.findFlights();

    // Go the next page
    BlazedemoReservePage res = new BlazedemoReservePage();

    // Verify if find flight
    res.foundFlights("Flights");

    // Push button of first flight
    res.choseFlight(1);

    // Go the next page
    BlazedemoPurchasePage pur = new BlazedemoPurchasePage();

    // Verify if flight was reserved
    pur.reserveFlight("Your flight from Paris to Cairo has been reserved");

    // Completed form
    pur.inputName("Cesar");
    pur.inputAddres("Balvanera");
    pur.inputCity("Buenos Aires");
    pur.inputState("Buenos Aires");
    pur.inputZip("1081");
    pur.inputCardNum("1234567891234");
    pur.inputMonth("11");
    pur.inputYear("2020");
    pur.inputNameCard("Cesar Castro");

    // Push button of Purchase flight
    pur.purchaseFlight();

    // Go the next page
    BlazedemoConfirmationPage conf = new BlazedemoConfirmationPage();

    // Verify if flight was bought
    conf.confirFlight("Thank you");

    }
}
