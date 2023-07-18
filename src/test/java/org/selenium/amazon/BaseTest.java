package org.selenium.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.selenium.amazon.driverutils.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @Parameters({"browser"})
    @BeforeSuite(groups = {"regression","smoke","sanity"})
    public void setUp(String browser){
        LOGGER.info("Setting up the driver");
        DriverManager.getInstance().setUpDriver(browser);
    }

    @AfterMethod(groups = {"regression","smoke","sanity"})
    public void afterTest(ITestResult result){
        if(result.isSuccess()){
            System.out.println(result.getMethod().getMethodName()+"is a pass");
        }
    }

    @AfterSuite(groups = {"regression","smoke","sanity"})
    public void close(){
        LOGGER.info("Closing the driver");
        DriverManager.getInstance().closeDriver();
    }
}
