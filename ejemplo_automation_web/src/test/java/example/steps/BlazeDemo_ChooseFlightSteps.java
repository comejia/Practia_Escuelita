package example.steps;

import example.pages.BlazeDemo_ChooseFlight;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import org.junit.Assert;

public class BlazeDemo_ChooseFlightSteps {

    private BlazeDemo_ChooseFlight choosePage;

    public BlazeDemo_ChooseFlightSteps(){
        choosePage = new BlazeDemo_ChooseFlight();
    }


    public void VerifyChoosePageIsLoaded(FlightsOrigin origin, FlightsDestination destine) {
        Assert.assertEquals("Could not found flights", "Flights from " + origin + " to " + destine + ":", choosePage.getTitleChooseFlightPage().getText());
    }

    public void VerifySelectedFlight(FlightOptions option) {
        Assert.assertEquals("Flight 43 Not found", "43", choosePage.confirmSelectFlight(option).getText());
    }

    public void SelectFlightButton(FlightOptions option) {
        choosePage.setChooseFlight(option).click();
    }
}
