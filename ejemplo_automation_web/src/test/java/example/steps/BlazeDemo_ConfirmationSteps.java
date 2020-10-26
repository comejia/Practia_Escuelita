package example.steps;

import example.pages.BlazeDemo_ConfirmationPage;
import example.pages.content.PurchaseFormData;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BlazeDemo_ConfirmationSteps {

    private BlazeDemo_ConfirmationPage confirmationPage;

    public BlazeDemo_ConfirmationSteps(){
        confirmationPage = new BlazeDemo_ConfirmationPage();
    }

    @Step("Verify confirmation")
    public BlazeDemo_ConfirmationSteps VerifyConfirmationIsLoaded() {
        Assert.assertEquals("Could not buy flight", "Thank you for your purchase today!", confirmationPage.getMessage());
        return this;
    }

    @Step("Verify card data")
    public BlazeDemo_ConfirmationSteps VerifyCardData(PurchaseFormData client) {
        Assert.assertEquals("Failed to check month and year", client.get_month() +" /" + client.get_year(), confirmationPage.getCheckData());
        return this;

    }



}
