package example.pages;



import Pages.WebComponent;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BlazeDemo_HomePage extends WebComponent {

    private By originChoose = By.xpath("//select[@name = 'fromPort']");
    private By destineChoose = By.xpath("//select[@name = 'toPort']");
    private By btnFindFlights = By.xpath("//body//input[@value='Find Flights']");
    public By homeMessage = By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]");
    private By homeButton = By.xpath("//div[@class='navbar navbar-inverse']//a[@href='home']");

    public BlazeDemo_HomePage()
    {
       getDriver().get("http://blazedemo.com/");
    }

    public WebElement getHomeMessage()
    {
        //TODO: Implementar el find con espera
        return getDriver().findElement(homeMessage);
    }


    public void clickHomeButton()
    {
         getDriver().findElement(homeButton).click();
    }

    /**
     * Set the flight destination
     * @param origin
     */
    public void setOriginChoose(FlightsOrigin origin) {
        By originBy = By.xpath("//select[@name = 'fromPort']//option[text() = '" + origin + "']");
        getDriver().findElement(originChoose).click();
        getDriver().findElement(originBy).click();
    }

    public void setDestineChoose(FlightsDestination destination) {
        By destinationBy = By.xpath("//select[@name = 'toPort']//option[text() = '" + destination + "']");
        getDriver().findElement(destineChoose).click();
        getDriver().findElement(destinationBy).click();
    }


    public void clickFindFlights()
    {
        getDriver().findElement(btnFindFlights).click();
    }

    public String getValueBtnFindFlights() {
        return getDriver().findElement(btnFindFlights).getAttribute("value");
    }

}
