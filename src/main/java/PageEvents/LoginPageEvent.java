package PageEvents;

import PageObjects.LoginPageElement;
import Utils.ElementFetch;
import org.testng.Assert;

public class LoginPageEvent {
    ElementFetch ef = new ElementFetch();
    public void ValidateLoginPageLoaded(){
        Assert.assertTrue(ef.findWebElement("XPATH", LoginPageElement.loginText).isEmpty(),"Element not found");
    }
}
