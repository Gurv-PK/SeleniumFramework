package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernametxtbox = By.xpath("//*[@id=\"user-name\"]");
    private By passwordtxtbox = By.xpath("//*[@id=\"password\"]");
    private By loginbutton = By.xpath("//*[@id=\"login-button\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterCreds(String username, String password){
        driver.findElement(usernametxtbox).clear();
        driver.findElement(usernametxtbox).sendKeys(username);
        driver.findElement(passwordtxtbox).clear();
        driver.findElement(passwordtxtbox).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginbutton).click();
    }

}
