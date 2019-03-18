package example.pages;

import Helpers.DriverWeb;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Test.BaseTest;

import java.lang.ref.SoftReference;

public class blazedemo_purchase extends BaseTest{

    public void reserveFlight(String buscar){Assert.assertNotNull("Could not reserve flight", findElement(By.xpath("//h2[contains(text(),'"+buscar+"')]"), 5, false)); }

    public void inputName(String name) {findElement(By.xpath("//input[@id = 'inputName']")).sendKeys(name); }

    public void inputAddres(String addres) {findElement(By.xpath("//input[@id = 'address']")).sendKeys(addres); }

    public void inputCity(String city) {findElement(By.xpath("//input[@id = 'city']")).sendKeys(city); }

    public void inputState(String state) {
        findElement(By.xpath("//input[@id = 'state']")).sendKeys(state);
    }

    public void inputZip(String zip) {
        findElement(By.xpath("//input[@id = 'zipCode']")).sendKeys(zip);
    }

    public void inputCardNum(String cardn) {findElement(By.xpath("//input[@id = 'creditCardNumber']")).sendKeys(cardn); }

    public void inputMonth(String month) {findElement(By.xpath("//input[@id = 'creditCardMonth']")).sendKeys(month); }

    public void inputYear(String year) {
        findElement(By.xpath("//input[@id = 'creditCardYear']")).sendKeys(year);
    }

    public void inputNameCard(String name) {
        findElement(By.xpath("//input[@id = 'nameOnCard']")).sendKeys(name);
    }

    public void purchaseFlight() {findElement(By.xpath("//body//input[@value='Purchase Flight']")).click(); }
}
