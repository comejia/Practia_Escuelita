package example.steps;

import example.pages.BlazeDemo_Form;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import example.pages.content.PurchaseFormData;
import org.junit.Assert;

public class BlazeDemo_FormSteps {
    BlazeDemo_Form formPage;

    public BlazeDemo_FormSteps(){
        formPage = new BlazeDemo_Form();
    }

    public void VerifyFormPageIsLoaded(FlightsOrigin origin, FlightsDestination destine) {
        Assert.assertEquals("Failed to load form page", "Your flight from "+ origin +" to "+ destine +" has been reserved.", formPage.getTitleForm());
    }


    public void CompleteFormData(PurchaseFormData client ) {
        formPage.completeForm(client);
    }
    public void CompleteCardData(PurchaseFormData client ) {
        formPage.completeCardForm(client);
    }


    public void PressPurchaseFlightButton( ) {
        formPage.purchaseFlight();
    }


}
