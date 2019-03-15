import Helpers.DriverWeb;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import example.testSteps.ExampleSteps;
import Test.BaseTest;

import java.util.logging.Logger;

public class TC2 extends BaseTest  {

@Test
    public void test2()  throws Exception {


    WebDriver web = DriverWeb.getInstance();
    web.get("http://blazedemo.com/");

    Assert.assertNotNull("Page not found", findElement(By.xpath("//body//input[@value='Find Flights']"), 5, false));

    WebElement origen = findElement(By.xpath("//select ['fromPort']"));
    origen.click();

    WebElement partida = findElement(By.xpath("//select [@name = 'fromPort'] / option[text()='Paris']"));
    partida.click();

    WebElement destino = findElement(By.xpath("//select ['toPort']"));
    destino.click();

    WebElement llegada = findElement(By.xpath("//select [@name = 'toPort'] / option[text()='Cairo']"));
    llegada.click();

    WebElement button = findElement(By.xpath("//body//input[@value='Find Flights']"));
    button.click();

    Assert.assertNotNull("Could not found flights", findElement(By.xpath("//h3[contains(text(),'Flights')]"), 5, false));

    WebElement buttonfl = findElement(By.xpath("//tbody/tr[1]//input[@value='Choose This Flight']"));
    buttonfl.click();

    Assert.assertNotNull("Could not reserve flight", findElement(By.xpath("//h2[contains(text(),'Your flight from Paris to Cairo has been reserved')]"), 5, false));

    WebElement inputText1 = findElement(By.xpath("//input[@id = 'inputName']"));
    inputText1.sendKeys("Gabriel Caprarella");

    WebElement inputText2 = findElement(By.xpath("//input[@id = 'address']"));
    inputText2.sendKeys("Juan B Justo");

    WebElement inputText3 = findElement(By.xpath("//input[@id = 'city']"));
    inputText3.sendKeys("Capital Federal");

    WebElement inputText4 = findElement(By.xpath("//input[@id = 'state']"));
    inputText4.sendKeys("Buenos Aires");

    WebElement inputText5 = findElement(By.xpath("//input[@id = 'zipCode']"));
    inputText5.sendKeys("12345");

    WebElement inputText6 = findElement(By.xpath("//input[@id = 'creditCardNumber']"));
    inputText6.sendKeys("123456789101");

    WebElement inputText7 = findElement(By.xpath("//input[@id = 'creditCardMonth']"));
    inputText7.sendKeys("5");

    WebElement inputText8 = findElement(By.xpath("//input[@id = 'creditCardYear']"));
    inputText8.sendKeys("2022");

    WebElement inputText9 = findElement(By.xpath("//input[@id = 'nameOnCard']"));
    inputText9.sendKeys("Gabriel Caprarella");

    WebElement buttonPF = findElement(By.xpath("//body//input[@value='Purchase Flight']"));
    buttonPF.click();

    Assert.assertNotNull("Could not buy the flight", findElement(By.xpath("//h1[contains(text(),'Thank you')]"), 5, false));
}

}
