package example.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class BlazeDemoHomePage {
    WebDriver driver;

    By originChoose = By.xpath("//select[@name = 'fromPort']");
    By destineChoose = By.xpath("//select[@name = 'toPort']");
    By btnFindFlights = By.xpath("//body//input[@value='Find Flights']");


    public BlazeDemoHomePage(WebDriver driver) {
        this.driver = driver;
    }


    private void setOriginChoose(String strOrigin) {
        By origin = By.xpath("//select[@name = 'fromPort']//option[text() = '" + strOrigin + "']");

        driver.findElement(originChoose).click();

        driver.findElement(origin).click(); /*Selecciono Origen en la lista*/

    }

    private void setDestineChoose(String strDestine) {

        By destine = By.xpath("//select[@name = 'toPort']//option[text() = '" + strDestine + "']");

        driver.findElement(destineChoose).click();

        driver.findElement(destine).click(); /*Selecciono Destino en la lista*/
    }


    private void clickFindFlights()
    {
        driver.findElement(btnFindFlights).click();
    }


    public void selectOriginAndDestine(String strOrigin, String strDestine)
    {
        this.setOriginChoose(strOrigin);
        this.setDestineChoose(strDestine);

        this.clickFindFlights();
    }


    public String getValueBtnFindFlights() {
        return driver.findElement(btnFindFlights).getAttribute("value");
    }
}
