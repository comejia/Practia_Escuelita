package example.steps;

import example.pages.BlazeDemo_HomePage;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BlazeDemo_HomeSteps {

    private BlazeDemo_HomePage homePage;

    public BlazeDemo_HomeSteps(){
        homePage = new BlazeDemo_HomePage();
    }

    @Step("Validate load home")
    public BlazeDemo_HomeSteps ValidateHomeIsLoaded() {
        Assert.assertNotNull("Couldn't find home page", homePage.getHomeMessage());
        return this;
    }

    @Step("Button is pressed")
    public BlazeDemo_HomeSteps PressFindFlightsButton() {
        Assert.assertEquals("Couldn't find select flight button", "Find Flights", homePage.getValueBtnFindFlights());
        homePage.getFindFlightsButton().click();
        return this;
    }

    @Step("Select destination city")
    public BlazeDemo_HomeSteps SelectDestinationCity(FlightsDestination destine) {
        Assert.assertNotNull("Couldn't find destine list", homePage.destineList());
        homePage.destineList().click();
        Assert.assertNotNull("Couldn't find selected destine", homePage.destineOption(destine));
        homePage.destineOption(destine).click();
        return this;
    }

    @Step("Select origin city")
    public BlazeDemo_HomeSteps SelectDepartureCity(FlightsOrigin origin) {
        Assert.assertNotNull("Couldn't find origin list", homePage.originList());
        homePage.originList().click();
        Assert.assertNotNull("Couldn't find selected origin", homePage.originOption(origin));
        homePage.originOption(origin).click();
        return this;
    }

}
