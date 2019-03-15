package Test;

import Helpers.DriverWeb;
import Helpers.PagesManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class BaseTest {

    @After
    public void close() throws Exception {
        PagesManager.close();
    }

    protected WebElement findElement(By by) {
        return find(by, (20/1000), 0, true);
    }

    private WebElement findElement(By by, int timeout, boolean throwException) {
        return find(by, (timeout/1000), 0, false);
    }

    private WebElement find(By by, int timeouot, int currentLap, boolean throwException) {

        try {
            return DriverWeb.getInstance().findElement(by);
        } catch (StaleElementReferenceException se) {
            try {
                Thread.sleep(1000);
            }catch (Exception e) {}
            if(throwException) {
                Assert.assertNotEquals("No se encontro el elemento " + by.toString(), currentLap, timeouot);
            }
            currentLap++;
            return find(by, timeouot, currentLap, throwException);
        }
    }

}
