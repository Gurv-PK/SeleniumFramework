package Base;

import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod
    public void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(Constants.url);
    }

    @AfterMethod
    public void teardown(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }
}
