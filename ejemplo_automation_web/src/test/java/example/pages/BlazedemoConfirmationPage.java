package example.pages;

import Test.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BlazedemoConfirmationPage extends BaseTest {

    public void confirFlight(String buscar){Assert.assertNotNull("Could not reserve flight", findElement(By.xpath("//h1[contains(text(),'"+buscar+"')]"), 5, false)); }

}