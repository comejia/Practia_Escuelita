package example.steps;

import example.pages.BlazeDemo_ChooseFlight;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BlazeDemo_ChooseFlightSteps {

    private BlazeDemo_ChooseFlight choosePage;

    public BlazeDemo_ChooseFlightSteps(){
        choosePage = new BlazeDemo_ChooseFlight();
    }

    @Step("Verify choose page is load")
    public void VerifyChoosePageIsLoaded(FlightsOrigin origin, FlightsDestination destine) {
        Assert.assertEquals("Could not found flights", "Flights from " + origin + " to " + destine + ":", choosePage.getTitleChooseFlightPage().getText());
    }

    @Step("Verify selected flight")
    public void VerifySelectedFlight(FlightOptions option) {
        Assert.assertEquals("Flight Not found", option.getIdFlight(), choosePage.confirmSelectFlight(option).getText());
    }

    @Step("Select flight")
    public void SelectFlightButton(FlightOptions option) {
        choosePage.setChooseFlight(option).click();
    }
}
