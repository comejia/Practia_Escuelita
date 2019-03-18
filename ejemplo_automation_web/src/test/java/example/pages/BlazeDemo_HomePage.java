package example.pages;



import Pages.WebComponent;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class BlazeDemo_HomePage extends WebComponent {
    WebDriver driver;

    By originChoose = By.xpath("//select[@name = 'fromPort']");
    By destineChoose = By.xpath("//select[@name = 'toPort']");
    By btnFindFlights = By.xpath("//body//input[@value='Find Flights']");
    public By homeMessage = By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]");
    By homeButton = By.xpath("//div[@class='navbar navbar-inverse']//a[@href='home']");

    public BlazeDemo_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomeMessage()
    {
        //TODO: Implementar el find con espera
        return driver.findElement(homeMessage).getText();
    }

    public void clickHomeButton()
    {
        driver.findElement(homeButton).click();     //wait.until(ExpectedConditions.elementToBeClickable(...);
    }

    /**
     * Set the flight destination
     * @param origin
     */
    public void setOriginChoose(FlightsOrigin origin) {
        By originBy = By.xpath("//select[@name = 'fromPort']//option[text() = '" + origin + "']");
        driver.findElement(originChoose).click();
        driver.findElement(originBy).click();
    }

    public void setDestineChoose(FlightsDestination destination) {
        By destinationBy = By.xpath("//select[@name = 'toPort']//option[text() = '" + destination + "']");
        driver.findElement(destineChoose).click();
        driver.findElement(destinationBy).click();
    }


    public void clickFindFlights()
    {
        driver.findElement(btnFindFlights).click();
    }


    public void selectOriginAndDestine(FlightsOrigin origin, FlightsDestination destination)
    {
        this.setOriginChoose(origin);
        this.setDestineChoose(destination);
        this.clickFindFlights();
    }


    public String getValueBtnFindFlights() {
        return driver.findElement(btnFindFlights).getAttribute("value");
    }

    public boolean homeMessageIsDisplayed() {
        return waitForSelectableElement(homeMessage, 20, false);
    }
}
