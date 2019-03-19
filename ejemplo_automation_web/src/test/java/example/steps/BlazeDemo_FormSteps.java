package example.steps;

import example.pages.BlazeDemo_Form;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import example.pages.content.PurchaseFormData;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BlazeDemo_FormSteps {
    BlazeDemo_Form formPage;

    public BlazeDemo_FormSteps(){
        formPage = new BlazeDemo_Form();
    }

    @Step("Verify form is load")
    public void VerifyFormPageIsLoaded(FlightsOrigin origin, FlightsDestination destine) {
        Assert.assertEquals("Failed to load form page", "Your flight from "+ origin +" to "+ destine +" has been reserved.", formPage.getTitleForm());
    }

    @Step("Complete form data")
    public void CompleteFormData(PurchaseFormData client ) {
        formPage.completeForm(client);
    }
    @Step("Complete card data")
    public void CompleteCardData(PurchaseFormData client ) {
        formPage.completeCardForm(client);
    }


    @Step("Purchase flight button")
    public void PressPurchaseFlightButton( ) {
        formPage.purchaseFlight();
    }


}
