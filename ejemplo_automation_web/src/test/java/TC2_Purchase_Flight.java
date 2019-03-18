import Helpers.DriverWeb;
import example.pages.blazedemo;
import example.pages.blazedemo_confirmation;
import example.pages.blazedemo_purchase;
import example.pages.blazedemo_reserve;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Test.BaseTest;

public class TC2_Purchase_Flight{


@Test
    public void test2()  throws Exception {

    // Open Browser
    WebDriver web = DriverWeb.getInstance();
    web.get("http://blazedemo.com/");
    blazedemo blaze = new blazedemo();

    // Verify the home page
    blaze.homePage();

    // Input origin and destination
    blaze.setOrigen("Paris");
    blaze.setDestino("Cairo");

    // Push button [Find Flights]
    blaze.findFlights();

    // Go the next page
    blazedemo_reserve res = new blazedemo_reserve();

    // Verify if find flight
    res.foundFlights("Flights");

    // Push button of first flight
    res.choseFlight(1);

    // Go the next page
    blazedemo_purchase pur = new blazedemo_purchase();

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
    blazedemo_confirmation conf = new blazedemo_confirmation();

    // Verify if flight was bought
    conf.confirFlight("Thank you");

    }
}
