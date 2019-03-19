package example.pages;

import Pages.WebComponent;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsOrigin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;



public class BlazeDemo_ChooseFlight extends WebComponent
{
    By titleChooseFlightPage = By.xpath("//body//h3");

     By flight = By.xpath("//input[@value='Choose This Flight']");
     List<WebElement> listFlights;



    public WebElement confirmSelectFlight(FlightOptions indexFlight){
            return driver.findElement(By.xpath("//tr["+indexFlight.getFlightOptions()+"]/td[text() = '"+indexFlight.getIdFlight()+"']"));
    }

     public WebElement setChooseFlight(FlightOptions indexFlight)
     {
         listFlights = getDriver().findElements(flight);
         return listFlights.get(indexFlight.getFlightOptions() - 1);
     }

    public WebElement getTitleChooseFlightPage() {
        return getDriver().findElement(titleChooseFlightPage);
    }
}
