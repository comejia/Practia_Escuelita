package example.pages;


import Test.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class blazedemo extends BaseTest {

    public void homePage(){Assert.assertNotNull("Page not found", findElement(By.xpath("//body//input[@value='Find Flights']"), 2, false)); }

    public void setOrigen(String Origen) {
        findElement(By.xpath("//select ['fromPort']")).click();

        findElement(By.xpath("//select [@name = 'fromPort'] / option[text()='"+Origen+"']")).click();
    }

    public void setDestino(String Destino) {
        findElement(By.xpath("//select ['toPort']")).click();

        findElement(By.xpath("//select [@name = 'toPort'] / option[text()='" + Destino + "']")).click();
    }

    public void findFlights() {findElement(By.xpath("//body//input[@value='Find Flights']")).click(); }

}
