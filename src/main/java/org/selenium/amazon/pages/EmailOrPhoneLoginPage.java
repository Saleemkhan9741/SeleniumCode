package org.selenium.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailOrPhoneLoginPage extends PageInitializer{

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement enterMobileOrPhoneTextField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public void enteringMobileOrEmailId(String emailId){
        sendKeys(enterMobileOrPhoneTextField,"entering "+emailId+" ");
    }

    public void clickOnContinueButton(){
        click(continueButton,"clicking on continue button");
    }
}
