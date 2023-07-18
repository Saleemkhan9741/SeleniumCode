package org.selenium.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.selenium.amazon.driverutils.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setUp(){
        LOGGER.info("Setting up the driver");
        DriverManager.getInstance().setUpDriver();
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        if(result.isSuccess()){
            System.out.println(result.getMethod().getMethodName()+"is a pass");
        }
    }

    @AfterSuite
    public void close(){
        LOGGER.info("Closing the driver");
        DriverManager.getInstance().closeDriver();
    }
}
