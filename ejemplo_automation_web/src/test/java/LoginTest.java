import Helpers.DriverWeb;
import example.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Test.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class LoginTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginTest.class));

    @Before
    public void open() {
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Register and login successfully test")
    public void testRegisterAndLogin_OK() {




        /*----------------HOME-PAGE--------------*/

        BlazeDemo_HomePage homePage = new BlazeDemo_HomePage();

        Assert.assertTrue(homePage.IsDisplayed(homePage.homeMessage));
        Assert.assertEquals(homePage.getHomeMessage(), "Welcome to the Simple Travel Agency!");
        homePage.clickHomeButton();

        /*----------------LOGIN-PAGE--------------*/

        BlazeDemo_Login loginPage = new BlazeDemo_Login();

        Assert.assertTrue(loginPage.IsDisplayed(loginPage.loginAnchor));
        Assert.assertEquals(loginPage.getLoginAnchor().getText(), "Login");
        loginPage.clickRegisterButton();

        /*----------------REGISTER-PAGE--------------*/

        BlazeDemo_Register registerPage = new BlazeDemo_Register();

        Assert.assertTrue(registerPage.IsDisplayed(registerPage.registerAnchor));
        Assert.assertEquals(registerPage.getRegisterAnchor(),"Register");
        registerPage.registerToBlazeDemo("Usuario", "compania", "usuario@server.com", "123123", "123123");
        registerPage.clickRegisterButton();

        /*---------------BACK-TO-LOGIN-PAGE--------------*/

        Assert.assertTrue(loginPage.IsDisplayed(loginPage.loginAnchor));
        Assert.assertEquals(loginPage.getLoginAnchor().getText(), "Login");
        loginPage.loginToBlazeDemo("usuario@server.com","123123");
        loginPage.clickLoginButton();

        /*----------------LOGIN-SUCCESS-PAGE--------------*/

        BlazeDemo_LoginSuccess loginSuccessPage = new BlazeDemo_LoginSuccess();

        Assert.assertTrue(loginSuccessPage.IsDisplayed(loginSuccessPage.successMessage));
        Assert.assertEquals(loginSuccessPage.getSuccessMessage().getText(), "You are logged in!");
    }
}