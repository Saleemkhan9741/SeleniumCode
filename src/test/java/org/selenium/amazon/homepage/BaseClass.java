package org.selenium.amazon.homepage;

import org.selenium.amazon.pages.AmazonHomePage;
import org.selenium.amazon.pages.CartPage;
import org.selenium.amazon.pages.EmailOrPhoneLoginPage;
import org.selenium.amazon.pages.PasswordLoginPage;

public class BaseClass {

    public AmazonHomePage amazonHomePage;
    public CartPage cartPage;
    public EmailOrPhoneLoginPage emailOrPhoneLoginPage;
    public PasswordLoginPage passwordLoginPage;

    public BaseClass(){
        amazonHomePage = new AmazonHomePage();
        cartPage = new CartPage();
        emailOrPhoneLoginPage = new EmailOrPhoneLoginPage();
        passwordLoginPage = new PasswordLoginPage();
    }
}
