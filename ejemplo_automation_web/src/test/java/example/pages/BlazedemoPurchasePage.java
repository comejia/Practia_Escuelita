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

        findElement(By.xpath("//input[@id = 'inputName']")).sendKeys(data.get_name());
        findElement(By.xpath("//input[@id = 'address']")).sendKeys(data.get_address());
        findElement(By.xpath("//input[@id = 'city']")).sendKeys(data.get_city());
        findElement(By.xpath("//input[@id = 'state']")).sendKeys(data.get_state());
        findElement(By.xpath("//input[@id = 'zipCode']")).sendKeys(data.get_zip());
        findElement(By.xpath("//input[@id = 'creditCardNumber']")).sendKeys(data.get_cardNum());
        findElement(By.xpath("//input[@id = 'creditCardMonth']")).sendKeys(data.get_month());
        findElement(By.xpath("//input[@id = 'creditCardYear']")).sendKeys(data.get_year());
        findElement(By.xpath("//input[@id = 'nameOnCard']")).sendKeys(data.get_nameCard());

    }

    public void purchaseFlight() {
        findElement(By.xpath("//body//input[@value='Purchase Flight']")).click();
    }
}
