package Pages;

import Helpers.ConfigHelperWeb;
import Helpers.DriverWeb;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implements basic web component abstraction (ie: frame, toolbar).
 * Used to map a web page component with a java class.
 */
public class WebComponent {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(WebComponent.class));
    private static int MAX_WAIT_FOR_SELECTABLE = 0; // millis

    protected WebDriver driver = null;

    /**
     * Constructor to create Web Browser associated with WebComponent.
     */
    protected WebComponent() {
        driver = DriverWeb.getInstance();
        if(MAX_WAIT_FOR_SELECTABLE == 0) {
            // getAppDefaultWait() * 1000 to have millisecods
            MAX_WAIT_FOR_SELECTABLE = ConfigHelperWeb.getAppDefaultWait() * 1000;
        }
    }

    /**
     * Close the Web Browser associated with WebComponent.
     */
    public void close() {
        //driver.close();
        DriverWeb.closeDriver();
    }

    /**
     * To wait execution for millis miliseconds
     * @param millis
     * @throws Exception
     */
    protected void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {}
    }

    /**
     * Implement mouse click on WebElement. Just waiting for WebElement to be clickable.
     * @param locator WebElement to click on.
     */
    protected void click(By locator) throws Exception {
        boolean click_ok= false;
        int time_wait = 0;
        while (!click_ok && (time_wait<=MAX_WAIT_FOR_SELECTABLE)) {
            try {
                findElement(locator).click();
                click_ok = true;
            } catch(Exception e) {
                LOGGER.log(Level.INFO, "click waiting locator["+locator+"]");
                wait(200);
                time_wait+= 200;
            }
        }
        if(!click_ok) {
            LOGGER.log(Level.INFO, "click not posible...");
            throw new Exception("click Not possible to find element By["+locator+"]");
        }
    }

    /**
     * Wait for "xpath" to be selectable for interaction.
     * @param xpath xpath for element to wait for being selectable.
     */
    protected boolean waitForSelectableElementByXPath(String xpath) throws Exception {
       return waitForSelectableElementByXPath(xpath, MAX_WAIT_FOR_SELECTABLE, true);
    }

    protected boolean waitForSelectableElementByXPath(String xpath, boolean throwException) throws Exception {
        return waitForSelectableElementByXPath(xpath, MAX_WAIT_FOR_SELECTABLE, throwException);
    }

    /**
     * Wait for "xpath" to be selectable for interaction.
     * @param xpath xpath for element to wait for being selectable.
     */
    protected boolean waitForSelectableElementByXPath(String xpath, int timeout) throws Exception {
        return waitForSelectableElementByXPath(xpath, timeout, true);
    }

    /**
     * Wait for "xpath" to be selectable for interaction.
     * @param xpath xpath for element to wait for being selectable.
     */
    protected boolean waitForSelectableElementByXPath(String xpath, int timeout, boolean throwException) throws Exception {
        return waitForSelectableElement(By.xpath(xpath), timeout, throwException);
    }

    /**
     * Wait for "xpath" to be selectable for interaction.
     *
     */
    protected boolean waitForSelectableElement(By by, int timeout, boolean throwException) {
        int time_wait = 0;
        boolean selectable = false;
        LOGGER.log(Level.INFO, "waitForSelectableElementByXPath xpath[" + by.toString() + "]");
        while ((!selectable) && (time_wait <= timeout)) {
            try {
                WebElement we = findElement(by, 1, false);
                if(we.isDisplayed() && we.isEnabled()) {
                    selectable = true;
                } else {
                    wait(1000);
                    time_wait += 1000;
                }
            } catch(Exception e) {
                wait(1000);
                time_wait += 1000;
            }
        }
        if(throwException) {
            Assert.assertTrue("No se encontro el elemento [" +  by.toString() + "] en el HTML", selectable);
        } else {
            return selectable;
        }
        LOGGER.log(Level.INFO, "waitForSelectableElementByXPath xpath[" +  by.toString() + "]--->["+selectable+"]");
        return selectable;
    }

    protected String getText(By locator){

        waitForSelectableElement(locator, MAX_WAIT_FOR_SELECTABLE, true);
        String text = findElement(locator).getText();
        LOGGER.log(Level.INFO,"Element finded in DOM and it is visible: " + locator.toString());
        return text;
    }

    protected String getAttributeValue(By locator, String attribute){

        waitForSelectableElement(locator, MAX_WAIT_FOR_SELECTABLE, true);
        String value = findElement(locator).getAttribute(attribute);;
        LOGGER.log(Level.INFO,"Element finded in DOM and it is visible: " + locator.toString());
        return value;
    }

    protected void sendKeys(By locator, String text)
    {
        waitForSelectableElement(locator, MAX_WAIT_FOR_SELECTABLE, true);
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
        LOGGER.log(Level.INFO,"Element finded in DOM and text writed into the element successfully: " + locator.toString());
    }

    protected boolean isAvailable(By locator){

        waitForSelectableElement(locator, MAX_WAIT_FOR_SELECTABLE, true);
        boolean available = false;
        try {
            WebElement we = findElement(locator);
            available = (we.isDisplayed() && we.isEnabled());
        } catch (Exception e) {}
        return available;
    }
    /**
     *
     * @return the WebDriver asociated with WebComponent
     */
    protected WebDriver getDriver() {
        return driver;
    }


    private WebElement findElement(By by) {
        return find(by, (MAX_WAIT_FOR_SELECTABLE/1000), 0, true);
    }

    private WebElement findElement(By by, int timeout, boolean throwException) {
        return find(by, (timeout/1000), 0, false);
    }

    private WebElement find(By by, int timeouot, int currentLap, boolean throwException) {

        try {
            return driver.findElement(by);
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
