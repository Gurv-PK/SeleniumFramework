package Utils;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {
    public WebElement getWebElement(String identifierType, String identifierValue){
        switch(identifierType){
            case "XPATH":
                return BaseTest.webdriver.findElement(By.xpath(identifierValue));
            case "CSS":
                return BaseTest.webdriver.findElement(By.cssSelector(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> findWebElement(String identifierType, String identifierValue){
        switch(identifierType){
            case "XPATH":
                return BaseTest.webdriver.findElements(By.xpath(identifierValue));
            case "CSS":
                return BaseTest.webdriver.findElements(By.cssSelector(identifierValue));
            default:
                return null;
        }
    }
}
