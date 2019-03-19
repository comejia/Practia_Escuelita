package example.steps;

import example.pages.BlazeDemo_HomePage;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import org.junit.Assert;

public class BlazeDemo_HomeSteps {

    private BlazeDemo_HomePage homePage;

    public BlazeDemo_HomeSteps(){
        homePage = new BlazeDemo_HomePage();
    }

    public void ValidateHomeIsLoaded() {
        Assert.assertNotNull("Couldn't find home page", homePage.getHomeMessage());
    }

    public void PressFindFlightsButton() {
        Assert.assertEquals("Couldn't find select flight button", "Find Flights", homePage.getValueBtnFindFlights());
        homePage.getFindFlightsButton().click();
    }

    public void SelectDestinationCity(FlightsDestination destine) {
        Assert.assertNotNull("Couldn't find destine list", homePage.destineList());
        homePage.destineList().click();
        Assert.assertNotNull("Couldn't find selected destine", homePage.destineOption(destine));
        homePage.destineOption(destine).click();
    }

    public void SelectDepartureCity(FlightsOrigin origin) {
        Assert.assertNotNull("Couldn't find origin list", homePage.originList());
        homePage.originList().click();
        Assert.assertNotNull("Couldn't find selected origin", homePage.originOption(origin));
        homePage.originOption(origin).click();
    }

}
