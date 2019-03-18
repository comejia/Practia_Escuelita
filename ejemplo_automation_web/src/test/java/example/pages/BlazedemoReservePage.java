package example.pages;

import Test.BaseTest;
import example.pages.content.FlightOptions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlazedemoReservePage extends BaseTest {

    public void choseFlight(int Opcion){
        findElement(By.xpath("//tbody/tr["+Opcion+"]//input[@value='Choose This Flight']")).click();
    }
}
