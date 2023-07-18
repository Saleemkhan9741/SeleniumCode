package org.selenium.amazon.driverutils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class Driver {

    private WebDriver webdriver;
    private static Driver driver;

    public static Driver getInstance() {
        if(driver == null){
            driver = new Driver();
        }
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.webdriver = driver;
    }

}
