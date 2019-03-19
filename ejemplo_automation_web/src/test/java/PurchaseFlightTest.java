import example.pages.*;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import example.pages.content.PurchaseFormData;
import example.steps.BlazeDemo_HomeSteps;
import org.junit.Assert;
import org.junit.Test;
import Test.BaseTest;

public class PurchaseFlightTest extends BaseTest {



    // ------------------------------------     T E S T S     ------------------------------------
    @Test
    public void test_purchaseFlight_firstFlightOption_OK() throws Exception {
        // ---------------------------   Entorno del test   ----------------------------
        FlightsOrigin origin = FlightsOrigin.PARIS;
        FlightsDestination destine = FlightsDestination.CAIRO;
        FlightOptions option = FlightOptions.ONE;

        BlazeDemo_HomeSteps homeSteps = new BlazeDemo_HomeSteps();



        // ---------------------------   Lógica del Test   ---------------------------
        homeSteps.ValidateHomeIsLoaded();
        homeSteps.SelectDepartureCity(origin);
        homeSteps.SelectDestinationCity(destine);
        homeSteps.PressFindFlightsButton();



        BlazeDemo_ChooseFlight chooseFlightPage = new BlazeDemo_ChooseFlight();

        Assert.assertEquals("Could not found flights", "Flights from " + origin + " to " + destine + ":", chooseFlightPage.getTitleChooseFlightPage().getText());
        Assert.assertEquals("Flight 43 Not found", "43", chooseFlightPage.confirmSelectFlight(option).getText());

        chooseFlightPage.setChooseFlight(option).click();

        BlazeDemo_Form purchasePage = new BlazeDemo_Form();
        Assert.assertEquals("Could not reserve flight", "Your flight from Paris to Cairo has been reserved.", purchasePage.getTitleForm());

        PurchaseFormData client = new PurchaseFormData("Cesar", "Balvanera", "Buenos Aires", "Buenos Aires", "1081", "1234567891234", "11", "2020", "Cesar Castro");
        purchasePage.completeForm(client);
        purchasePage.purchaseFlight();

        // Go the next page
        BlazeDemo_ConfirmationPage confirmationPage = new BlazeDemo_ConfirmationPage();

        Assert.assertEquals("Could not buy flight", "Thank you for your purchase today!", confirmationPage.getMessage());

    }
}

//    //@Test
//    @Severity(SeverityLevel.MINOR)
//    @DisplayName("Example: Test case 1 with POM")
//    public void test_purchaseFlight_secondFlightOption_OK() throws Exception {
//
//
//        String monthCard = "05";
//        String yearCard = "2000";
//        PurchaseFormData client = new PurchaseFormData(monthCard,yearCard);
//
//
//
//
//        //*********** HOME PAGE***************//
//
//
//
//
//        //*********** CHOICE fLIGHT ***************//
//        BlazeDemo_ChooseFlight choseFlight;
//        choseFlight = new BlazeDemo_ChooseFlight();
//        Assert.assertEquals("Failed to load flights", "Flights from "+ origin + " to " + destine +":", choseFlight.getTitleChooseFlightPage());
//        choseFlight.setChooseFlight(opcFlight);
//
//        //*********** FORM ***************//
//        BlazeDemo_Form form;
//        form = new BlazeDemo_Form();
//        Assert.assertEquals("Failed to load form page", "Your flight from "+ origin +" to "+ destine +" has been reserved.", form.getTitleForm());
//        form.completeMonthAndYearCard(client.get_month(), client.get_year());
//
//
//        //*********** CONFIRMATION ***************//
//        BlazeDemo_ConfirmationPage confirmation;
//        confirmation = new BlazeDemo_ConfirmationPage();
//        Assert.assertEquals("Failed to check month and year", client.get_month() +" /" + client.get_year(), confirmation.getCheckData());
//
//        Thread.sleep(3000);
//    }
//}
