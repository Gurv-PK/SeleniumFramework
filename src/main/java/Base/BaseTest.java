package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

    public static WebDriver webdriver;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports reports;
    public ExtentTest logger;
    @BeforeTest
    public void beforeTest(){

    }
}
