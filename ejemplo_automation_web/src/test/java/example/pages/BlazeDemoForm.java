package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoForm
{
    WebDriver driver;
     By titleForm = By.xpath("//body//h2");
     By monthCard = By.id("creditCardMonth");
     By yearCard = By.id("creditCardYear");
     By btnPurchaseFight = By.xpath("//input[@value='Purchase Flight']");

     public BlazeDemoForm(WebDriver driver)
     {
         this.driver = driver;
     }



     public String getTitleForm()
     {
        return driver.findElement(titleForm).getText();
     }


     private void setMonthCard(String strMonthCard)
     {
         driver.findElement(monthCard).clear();
         driver.findElement(monthCard).sendKeys(strMonthCard);
     }
    private void setYearCard(String strYearCard)
    {
        driver.findElement(yearCard).clear();
        driver.findElement(yearCard).sendKeys(strYearCard);
    }

    private void clickPurchaseFight()
    {
        driver.findElement(btnPurchaseFight).click();

    }


    public void completeMonthAndYearCard(String strMonth, String strYear)
    {
        this.setMonthCard(strMonth);
        this.setYearCard(strYear);
        this.clickPurchaseFight();
    }
}



