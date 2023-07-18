package org.selenium.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.selenium.amazon.driverutils.DriverManager;
import org.selenium.amazon.utils.PropertyReader;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @Parameters({"browser","env","headlessEnabled"})
    @BeforeSuite(groups = {"regression","smoke","sanity"})
    public void setUp(String browser, String env, boolean headlessEnabled) throws IOException {
        archivePreviousResult();
        LOGGER.info("Setting the environment");
        PropertyReader.environment = env;
        LOGGER.info("Current environment is set to  :{}", env);
        LOGGER.info("Setting up the driver");
        DriverManager.getInstance().setUpDriver(browser,headlessEnabled);
    }

    @AfterMethod(groups = {"regression","smoke","sanity"})
    public void afterTest(ITestResult result){

    }

    @AfterSuite(groups = {"regression","smoke","sanity"})
    public void close(){
        LOGGER.info("Closing the driver");
        DriverManager.getInstance().closeDriver();
    }

    private void archivePreviousResult() throws IOException {
        String dirPath = System.getProperty("user.dir") + File.separator + "reports";
        boolean previousFileExists = new File(dirPath).exists();
        if(previousFileExists){
            Path dir = Paths.get(dirPath);
            Files.walk(dir)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            System.out.println("Deleting: " + path);
                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

}
