package example.pages;

import Helpers.DriverWeb;
import com.fasterxml.jackson.databind.ser.Serializers;
import example.pages.content.PurchaseFormData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Test.BaseTest;

import java.lang.ref.SoftReference;

public class BlazedemoPurchasePage extends BaseTest {

    public void completeForm(PurchaseFormData data) {

    }


    public void reserveFlight(String buscar){Assert.assertNotNull("Could not reserve flight", findElement(By.xpath("//h2[contains(text(),'"+buscar+"')]"), 5, false)); }

    private void inputName(String name) {findElement(By.xpath("//input[@id = 'inputName']")).sendKeys(name); }

    private void inputAddres(String addres) {findElement(By.xpath("//input[@id = 'address']")).sendKeys(addres); }

    private void inputCity(String city) {findElement(By.xpath("//input[@id = 'city']")).sendKeys(city); }

    private void inputState(String state) {
        findElement(By.xpath("//input[@id = 'state']")).sendKeys(state);
    }

    private void inputZip(String zip) {
        findElement(By.xpath("//input[@id = 'zipCode']")).sendKeys(zip);
    }

    private void inputCardNum(String cardn) {findElement(By.xpath("//input[@id = 'creditCardNumber']")).sendKeys(cardn); }

    private void inputMonth(String month) {findElement(By.xpath("//input[@id = 'creditCardMonth']")).sendKeys(month); }

    private void inputYear(String year) {
        findElement(By.xpath("//input[@id = 'creditCardYear']")).sendKeys(year);
    }

    private void inputNameCard(String name) {
        findElement(By.xpath("//input[@id = 'nameOnCard']")).sendKeys(name);
    }

    private void purchaseFlight() {findElement(By.xpath("//body//input[@value='Purchase Flight']")).click(); }
}
