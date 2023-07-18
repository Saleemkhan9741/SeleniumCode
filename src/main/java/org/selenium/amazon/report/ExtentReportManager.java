package org.selenium.amazon.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    public static ExtentReports createExtentReportInstance(){
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("reports");
        extentSparkReporter.config().setEncoding("utf-8");
        extentSparkReporter.config().setReportName("Amazon Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Document 1");
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }
}
