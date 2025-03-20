package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Baseclass;

public class Extentreport implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public   static WebDriver driver; // Ensure WebDriver instance is available

    @Override
    public void onStart(ITestContext context) {
        // Define report location
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/newreport.html");

        // Configure report
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        // Create ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system details
        extent.setSystemInfo("Tester", "Harish");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName()); // Creates a new test entry in the report
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.FAIL, result.getName() + " got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        String imgPath = new Baseclass().capturescreenshot(result.getName());
		test.addScreenCaptureFromPath(imgPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Generates final report
    }

   
    }

