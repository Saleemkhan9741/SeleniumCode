package org.selenium.amazon.driverutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.selenium.amazon.enums.Browsers;
import org.selenium.amazon.enums.Constants;
import org.selenium.amazon.utils.PropertyReader;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DriverManager {

    private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

    public ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static DriverManager driverManager;

    public static DriverManager getInstance() {
        if(driverManager == null){
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public void setUpDriver(){
        String browser = PropertyReader.getInstance().getConfigPropertyForGivenKey(Constants.BROWSER.getProperty());
        String url = PropertyReader.getInstance().getPropertyForGivenKey(Constants.URL.getProperty());
        boolean headless = Boolean.parseBoolean(PropertyReader
                .getInstance().getConfigPropertyForGivenKey(Constants.HEADLESS.getProperty()));
        LOGGER.info("Browser is set as {}",browser);
        LOGGER.info("URL is set as {}",url);
        LOGGER.info("headless is set as {}",headless);
        switch (Browsers.valueOf(browser.toUpperCase())){
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                WebDriver driver;
                ChromeOptions chromeOptions = null;
                if(headless) {
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                }else {
                    driver = new ChromeDriver();
                }
                threadLocalDriver.set(driver);
                break;
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver;
                FirefoxOptions firefoxOptions = null;
                if(headless) {
                    firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                }else {
                    driver = new FirefoxDriver();
                }
                threadLocalDriver.set(driver);
                break;
            }
            case IE -> {
                WebDriverManager.iedriver().setup();
                WebDriver driver;
                driver = new InternetExplorerDriver();
                threadLocalDriver.set(driver);
                break;
            }
            case SAFARI -> {
                WebDriverManager.safaridriver().setup();
                WebDriver driver;
                driver = new SafariDriver();
                threadLocalDriver.set(driver);
                break;
            }
            default -> throw new RuntimeException("Invalid Browser is defined");
        }
        WebDriver driver = threadLocalDriver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(2, ChronoUnit.SECONDS));
        driver.manage().deleteAllCookies();
        driver.get(url);
        Driver.getInstance().setDriver(driver);
    }

    public void closeDriver(){
        WebDriver currentDriver = Driver.getInstance().getWebdriver();
        String shouldClose = PropertyReader.getInstance().getConfigPropertyForGivenKey(Constants.CLOSE.getProperty());
        if(Boolean.parseBoolean(shouldClose)) {
            currentDriver.close();
            currentDriver.quit();
        }
    }
}
