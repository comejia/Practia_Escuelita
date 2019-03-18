package example.pages;

import example.pages.content.FlightsOrigin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;



public class BlazeDemo_ChooseFlight
{
    WebDriver driver;
    By titleChooseFlightPage = By.xpath("//body//h3");

     By flight = By.xpath("//input[@value='Choose This Flight']");
     List<WebElement> listFlights;


     public BlazeDemo_ChooseFlight(WebDriver driver)
     {
         this.driver = driver;
     }

    public String confirmSelectFlight(int indexFlight){
            return driver.findElement(By.xpath("//tr["+indexFlight+"]/td[text() = '43']")).getText();
    }

     public void setChooseFlight(int indexFlight)
     {
         listFlights = driver.findElements(flight);
         listFlights.get(indexFlight - 1).click();
     }

    public String getTitleChooseFlightPage() {
        return driver.findElement(titleChooseFlightPage).getText();
    }
}
