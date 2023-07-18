package org.selenium.amazon.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.amazon.BaseTest;
import org.selenium.amazon.driverutils.Driver;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonHomeTest extends BaseTest {

    @Test(groups = {"regression"})
    public void Test1(){
        System.out.println("Running test 1");
        WebDriver currentDriver = Driver.getInstance().getWebdriver();
        List<WebElement> links = currentDriver.findElements(By.xpath("//a"));
        links.forEach(x->{
            System.out.println(x.getText());
        });
    }
}
