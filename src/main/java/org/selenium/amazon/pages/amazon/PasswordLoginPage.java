package org.selenium.amazon.pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.amazon.pages.PageInitializer;

public class PasswordLoginPage extends PageInitializer {

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    public void enterPassword(String password){
        sendKeys(passwordTextField, password);
    }

    public void clickOnSignInButton(){
        doubleClick(signInButton,"Clicking on Sign In Button");
    }
}
