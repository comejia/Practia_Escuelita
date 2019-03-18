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
    
}
