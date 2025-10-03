package Test;

import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        loginPage.enterCreds("standard_user","secret_sauce");
        loginPage.clickLogin();

    }
}
