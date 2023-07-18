package org.selenium.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.selenium.amazon.driverutils.Driver;
import org.selenium.amazon.utils.PageUtility;

public class PageInitializer extends PageUtility {

    public WebDriver driver;

    public PageInitializer(){
        driver = Driver.getInstance().getWebdriver();
        PageFactory.initElements(driver,this);
    }
}
