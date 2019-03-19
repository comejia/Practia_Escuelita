import example.pages.*;
import example.pages.content.FlightOptions;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import example.pages.content.PurchaseFormData;
import example.steps.BlazeDemo_ChooseFlightSteps;
import example.steps.BlazeDemo_ConfirmationSteps;
import example.steps.BlazeDemo_FormSteps;
import example.steps.BlazeDemo_HomeSteps;
import io.qameta.allure.Severity;
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

        PurchaseFormData client = new PurchaseFormData("Cesar", "Balvanera", "Buenos Aires", "Buenos Aires", "1081", "1234567891234", "11", "2020", "Cesar Castro");

        BlazeDemo_HomeSteps homeSteps = new BlazeDemo_HomeSteps();
        BlazeDemo_ChooseFlightSteps chooseFlightSteps = new BlazeDemo_ChooseFlightSteps();
        BlazeDemo_FormSteps formSteps = new BlazeDemo_FormSteps();
        BlazeDemo_ConfirmationSteps confirmationSteps = new BlazeDemo_ConfirmationSteps();


        // ---------------------------   Lógica del Test   ---------------------------
        // Go the home page
        homeSteps.ValidateHomeIsLoaded();
        homeSteps.SelectDepartureCity(origin);
        homeSteps.SelectDestinationCity(destine);
        homeSteps.PressFindFlightsButton();

        // Go the next page
        chooseFlightSteps.VerifyChoosePageIsLoaded(origin, destine);
        chooseFlightSteps.VerifySelectedFlight(option);
        chooseFlightSteps.SelectFlightButton(option);

        // Go the next page
        formSteps.VerifyFormPageIsLoaded(origin, destine);
        formSteps.CompleteFormData(client);
        formSteps.PressPurchaseFlightButton();

        // Go the next page
        confirmationSteps.VerifyConfirmationIsLoaded();

    }


    @Test
    //@Severity(SeverityLevel)
    //@DisplayName("Example: Test case 1 with POM")
    public void test_purchaseFlight_secondFlightOption_OK() {
        // ---------------------------   Entorno del test   ----------------------------
        FlightsOrigin origin = FlightsOrigin.PARIS;
        FlightsDestination destine = FlightsDestination.BERLIN;
        FlightOptions option = FlightOptions.TWO;
        PurchaseFormData client = new PurchaseFormData("04","2050");

        BlazeDemo_HomeSteps homeSteps = new BlazeDemo_HomeSteps();
        BlazeDemo_ChooseFlightSteps chooseFlightSteps = new BlazeDemo_ChooseFlightSteps();
        BlazeDemo_FormSteps formSteps = new BlazeDemo_FormSteps();
        BlazeDemo_ConfirmationSteps confirmationSteps = new BlazeDemo_ConfirmationSteps();

        // ---------------------------   Lógica del HomeTest   ---------------------------
        homeSteps.ValidateHomeIsLoaded();
        homeSteps.SelectDepartureCity(origin);
        homeSteps.SelectDestinationCity(destine);
        homeSteps.PressFindFlightsButton();

        // Go the next page
        chooseFlightSteps.VerifyChoosePageIsLoaded(origin, destine);
        chooseFlightSteps.VerifySelectedFlight(option);
        chooseFlightSteps.SelectFlightButton(option);

        // Go the next page
        formSteps.VerifyFormPageIsLoaded(origin, destine);
        formSteps.CompleteCardData(client);
        formSteps.PressPurchaseFlightButton();

        // Go the next page
        confirmationSteps.VerifyCardData(client);
    }
}
