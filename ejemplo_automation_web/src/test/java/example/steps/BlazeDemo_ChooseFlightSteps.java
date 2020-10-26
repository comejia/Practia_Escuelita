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
    public BlazeDemo_ChooseFlightSteps VerifyChoosePageIsLoaded(FlightsOrigin origin, FlightsDestination destine) {
        Assert.assertEquals("Could not found flights", "Flights from " + origin + " to " + destine + ":", choosePage.getTitleChooseFlightPage().getText());
        return this;
    }

    @Step("Verify selected flight")
    public BlazeDemo_ChooseFlightSteps VerifySelectedFlight(FlightOptions option) {
        Assert.assertEquals("Flight Not found", option.getIdFlight(), choosePage.confirmSelectFlight(option).getText());
        return this;
    }

    @Step("Select flight")
    public BlazeDemo_ChooseFlightSteps SelectFlightButton(FlightOptions option) {
        choosePage.setChooseFlight(option).click();
        return this;
    }
}
