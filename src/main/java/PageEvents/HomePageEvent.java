package PageEvents;

import PageObjects.HomePageElement;
import Utils.ElementFetch;

public class HomePageEvent implements HomePageElement {
    ElementFetch ef = new ElementFetch();
    public void signInButton(){
        ef.getWebElement("XPATH",HomePageElement.signInButtonText).click();
    }

}
