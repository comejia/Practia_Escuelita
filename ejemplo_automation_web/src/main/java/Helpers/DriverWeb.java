package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverWeb {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(DriverWeb.class));

    private static WebDriver driver;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static WebDriver getInstance(){
        if (driver == null){
            createDriver();
            LOGGER.log(Level.INFO, "DriverWeb for "+capabilities.getBrowserName()+" has been created.");
        }

        return driver;
    }

    private static DesiredCapabilities getCapabilities(){
        capabilities.setBrowserName(ConfigHelperWeb.getBrowserName());
        return capabilities;
    }

    private static WebDriver createDriver(){
        DesiredCapabilities desiredCapabilities = getCapabilities();
        LOGGER.log(Level.INFO, "Creating a new instance of "+desiredCapabilities.getBrowserName()+" DriverWeb");

        String os = System.getProperty("os.name");
        LOGGER.log(Level.INFO, "Operating system: {0}",os);

        switch (os){
            // Linux
            case "Linux":
                switch (desiredCapabilities.getBrowserName()){
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", ConfigHelperWeb.getDriverPath("chrome"));
                        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("incognito");
                        chromeOptions.addArguments("--start-maximized"); // added
                        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                        chromeCapabilities.setCapability("pageLoadStrategy", "none"); // added

                        driver = new ChromeDriver(chromeCapabilities);
                        break;
                    case "firefox":
                        System.setProperty("webdriver.gecko.driver", ConfigHelperWeb.getDriverPath("firefox"));
                        DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("-private");
                        firefoxCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,firefoxOptions);
                        driver = new FirefoxDriver(firefoxCapabilities);
                        break;
                    default:
                        LOGGER.log(Level.WARNING, "Browser: {0} is not set or not support.", desiredCapabilities.getBrowserName());
                        break;
                }
                break;
            // Windows
            case "Windows 10": case "Windows Server 2012 R2": case "Windows Server 2008 R2":
                switch (desiredCapabilities.getBrowserName()){
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", ConfigHelperWeb.getDriverPath("chrome") + ".exe");
                        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("incognito");
                        chromeOptions.addArguments("--lang=es");
                        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                        driver = new ChromeDriver(chromeCapabilities);
                        break;
                    case "firefox":
                        System.setProperty("webdriver.gecko.driver", ConfigHelperWeb.getDriverPath("firefox") + ".exe");
                        DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("-private");
                        firefoxCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,firefoxOptions);
                        driver = new FirefoxDriver(firefoxCapabilities);
                        break;
                    default:
                        LOGGER.log(Level.WARNING, "Browser: {0} is not set or not support.", desiredCapabilities.getBrowserName());
                        break;
                }
                break;
            default:
                LOGGER.log(Level.WARNING, "Operating System: {0} is not support", os);
                break;
        }
        driver.manage().timeouts().pageLoadTimeout(Constants.SELENIUM_TIMEOPUT_LOAD_PAGE, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver=null;
    }
}
