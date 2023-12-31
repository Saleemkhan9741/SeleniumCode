package org.selenium.amazon.pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.amazon.pages.PageInitializer;

public class EmailOrPhoneLoginPage extends PageInitializer {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement enterMobileOrPhoneTextField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public void enteringMobileOrEmailId(String emailId){
        sendKeys(enterMobileOrPhoneTextField,emailId);
    }

    public void clickOnContinueButton(){
        doubleClick(continueButton,"clicking on continue button");
    }
}
