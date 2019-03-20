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
    public BlazeDemo_FormSteps VerifyFormPageIsLoaded(FlightsOrigin origin, FlightsDestination destine) {
        Assert.assertEquals("Failed to load form page", "Your flight from "+ origin +" to "+ destine +" has been reserved.", formPage.getTitleForm());
        return this;
    }

    @Step("Complete form data")
    public BlazeDemo_FormSteps CompleteFormData(PurchaseFormData client ) {
        formPage.completeForm(client);
        return this;
    }
    @Step("Complete card data")
    public BlazeDemo_FormSteps CompleteCardData(PurchaseFormData client ) {
        formPage.completeCardForm(client);
        return this;
    }


    @Step("Purchase flight button")
    public BlazeDemo_FormSteps PressPurchaseFlightButton( ) {
        formPage.purchaseFlight();
        return this;
    }


}
