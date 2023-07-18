package org.selenium.amazon.report.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.selenium.amazon.report.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private ExtentReports extentReports;

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentReportManager.createExtentReportInstance();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE){
            extentReports.createTest(result.getName())
                    .log(Status.FAIL,result.getName()+ "method has failed at : " +result.getThrowable());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if(result.isSuccess()){
            extentReports.createTest(result.getName())
                    .log(Status.PASS,result.getName()+"has passed");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
