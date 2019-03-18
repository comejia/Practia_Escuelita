package example.pages;

import Pages.WebComponent;
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



    public String confirmSelectFlight(int indexFlight){
            return getDriver().findElement(By.xpath("//tr["+indexFlight+"]/td[text() = '43']")).getText();
    }

     public void setChooseFlight(int indexFlight)
     {
         listFlights = getDriver().findElements(flight);
         listFlights.get(indexFlight - 1).click();
     }

    public String getTitleChooseFlightPage() {
        return getDriver().findElement(titleChooseFlightPage).getText();
    }
}
