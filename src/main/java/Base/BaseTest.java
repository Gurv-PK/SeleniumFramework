package Base;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.lang.reflect.Method;

public class BaseTest{

    public static WebDriver webdriver;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports reports;
    public ExtentTest logger;
    @BeforeTest
    public void beforeTest(){
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator+"reports"+File.separator+"SelFramework.html");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation report");
        sparkReporter.config().setReportName("Automation test framework report");
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser, Method method){
        logger = reports.createTest(method.getName());
        setupDriver(browser);
    }
    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == result.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - Test Case Failed", ExtentColor.RED));
        } else if (result.getStatus() == result.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - Test Case Skipped", ExtentColor.AMBER));
        }  else if (result.getStatus() == result.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Passed", ExtentColor.GREEN));
        }
        webdriver.quit();
    }
    @AfterTest
    public void afterTest(){
        reports.flush();
    }

    public void setupDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webdriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webdriver = new FirefoxDriver();
        }
    }
}


