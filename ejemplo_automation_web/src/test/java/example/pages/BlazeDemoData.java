package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoData
{
    WebDriver driver;
    By checkData = By.xpath("//body//tr[5]//td[2]");


    public BlazeDemoData(WebDriver driver)
    {
        this.driver = driver;
    }


    public String getCheckData()
    {
        return driver.findElement(checkData).getText();

    }

}
