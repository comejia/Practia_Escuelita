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

import javax.print.attribute.standard.Finishings;
import java.util.List;
import java.util.logging.Logger;

public class LoginTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginTest.class));

    protected ExampleSteps exampleSteps;

    @Before
    public void open() throws Exception {
        exampleSteps = new ExampleSteps();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Example: Test case 1")
    public void test() throws Exception {


        WebDriver webDriver = DriverWeb.getInstance();

        /*********** HOME PAGE***************/
        webDriver.get("http://blazedemo.com/");
        /*Obtengo referencia de que ingrese a la web*/
        WebElement buttonFF = webDriver.findElement(By.xpath("//body//input[@value='Find Flights']")); /*Boton find flight*/
        Assert.assertEquals("Failed to home page","Find Flights", buttonFF.getAttribute("value")); /*Validate go to page*/

        /*Selecciono origen de vuelo*/
        WebElement selectOrigen = webDriver.findElement(By.xpath("//select[@name = 'fromPort']"));
        selectOrigen.click();

        WebElement origen = webDriver.findElement(By.xpath("//select[@name = 'fromPort']//option[text()= 'Paris']"));
        origen.click(); /*Seleciono Paris en la lista */
        Assert.assertEquals("Failed to select origin","Paris",origen.getAttribute("value"));

        /*Selecciono destino de vuelo*/
        WebElement selectDestino = webDriver.findElement(By.xpath("//select[@name = 'toPort']"));
        selectDestino.click();

        WebElement destino = webDriver.findElement(By.xpath("//select[@name = 'toPort']//option[text()= 'Berlin']"));
        destino.click();
        Assert.assertEquals("Failed to select destination","Berlin",destino.getAttribute("value"));

        buttonFF.click(); /* Go to next page*/


        /*********** CHOICE fLIGHT ***************/
        WebElement titleFlightsPage = webDriver.findElement(By.xpath("//body//h3"));
        Assert.assertEquals("Failed to load flights","Flights from Paris to Berlin:",titleFlightsPage.getText());

        /*Elijo el segundo vuelo*/
        List<WebElement> ListBtnFly= webDriver.findElements(By.xpath("//input[@value='Choose This Flight']"));
        ListBtnFly.get(1).click();


        /*********** FORM ***************/
        WebElement titleFlightsReserved = webDriver.findElement(By.xpath("//body//h2"));
        Assert.assertEquals("Failed to load form page","Your flight from Paris to Berlin has been reserved.",titleFlightsReserved.getText());

        WebElement inputMonthCard = webDriver.findElement(By.id("creditCardMonth"));
        inputMonthCard.clear();
        inputMonthCard.sendKeys("04"); // set card month

        WebElement inputYearCard = webDriver.findElement(By.id("creditCardYear"));
        inputYearCard.clear();
        inputYearCard.sendKeys("2039"); // set year card

        WebElement btnPurchaseFlight = webDriver.findElement(By.xpath("//input[@value='Purchase Flight']"));
        btnPurchaseFlight.click(); // next page


        /*********** PURCHASE DATA***************/
        WebElement checkMonthAndYear = webDriver.findElement(By.xpath("//body//tr[5]//td[2]"));
        Assert.assertEquals("Failed to check month and year","04 /2039",checkMonthAndYear.getText());




    }

}
