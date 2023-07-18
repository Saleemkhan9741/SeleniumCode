package org.selenium.amazon.homepage;

import org.selenium.amazon.pages.amazon.AmazonHomePage;
import org.selenium.amazon.pages.amazon.CartPage;
import org.selenium.amazon.pages.amazon.EmailOrPhoneLoginPage;
import org.selenium.amazon.pages.amazon.PasswordLoginPage;

public class BaseClass{

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
