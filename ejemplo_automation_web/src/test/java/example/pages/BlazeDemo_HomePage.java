package example.pages;



import Pages.WebComponent;
import example.pages.content.FlightsDestination;
import example.pages.content.FlightsOrigin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        return getWebElement(homeMessage);
    }

    private WebElement getWebElement(By by) {
        try {
            return getDriver().findElement(by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void clickHomeButton()
    {
         getDriver().findElement(homeButton).click();
    }

    /**
     * Set the flight destination
     */
    public WebElement originList() {

        return getWebElement(originChoose); }

    public WebElement destineList() {
        return getWebElement(destineChoose);
    }

    public WebElement originOption(FlightsOrigin origin){
        return getWebElement((By.xpath("//select[@name = 'fromPort']//option[text() = '" + origin.toString() + "']")));
    }

    public WebElement destineOption(FlightsDestination destination){
        return getWebElement(By.xpath("//select[@name = 'toPort']//option[text() = '" + destination + "']"));
    }

    public WebElement getFindFlightsButton()
    {
        return getWebElement(btnFindFlights);
    }

    public String getValueBtnFindFlights() {
        return getWebElement(btnFindFlights).getAttribute("value");
    }

}
