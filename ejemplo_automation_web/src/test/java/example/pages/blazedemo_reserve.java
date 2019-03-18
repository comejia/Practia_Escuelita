package example.pages;

import Test.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class blazedemo_reserve extends BaseTest {

    public void foundFlights(String buscar){

        Assert.assertNotNull("Could not found flights", findElement(By.xpath("//h3[contains(text(),'"+buscar+"')]"), 2, false));
      // if (findElement(By.xpath("//h3[contains(text(),'"+buscar+"')]")).getText() == "Flights from Paris to Cairo: "){
      //     System.out.println("Vuelos reservado OK");
      // }
    }

    public void choseFlight(int Opcion){findElement(By.xpath("//tbody/tr["+Opcion+"]//input[@value='Choose This Flight']")).click(); }

}
