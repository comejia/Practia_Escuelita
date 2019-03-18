package example.pages;


import Test.BaseTest;
import example.pages.content.FlightsDestiny;
import example.pages.content.FlightsOrigin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlazedemoPage extends BaseTest {

    public void setOrigen(FlightsOrigin origen) {
        findElement(By.xpath("//select ['fromPort']")).click();
        findElement(By.xpath("//select [@name = 'fromPort'] / option[text()='"+origen.toString()+"']")).click();
    }

    public void setDestino(FlightsDestiny destino) {
        findElement(By.xpath("//select ['toPort']")).click();
        findElement(By.xpath("//select [@name = 'toPort'] / option[text()='" +destino + "']")).click();
    }

    public void findFlights() {
        findElement(By.xpath("//body//input[@value='Find Flights']")).click();
    }

}

