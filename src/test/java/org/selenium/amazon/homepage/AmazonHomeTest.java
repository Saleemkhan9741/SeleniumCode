package org.selenium.amazon.homepage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.selenium.BaseTest;
import org.selenium.amazon.pages.amazon.AmazonHomePage;
import org.selenium.amazon.pages.amazon.CartPage;
import org.selenium.amazon.pages.amazon.EmailOrPhoneLoginPage;
import org.selenium.amazon.pages.amazon.PasswordLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonHomeTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(AmazonHomeTest.class);

    @Test(groups = {"regression"})
    public void loginToAmazon(){
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        EmailOrPhoneLoginPage emailOrPhoneLoginPage = new EmailOrPhoneLoginPage();
        PasswordLoginPage passwordLoginPage = new PasswordLoginPage();
        amazonHomePage.moveToHelloSignInAccount();
        amazonHomePage.clickOnHelloSignInAccount();
        emailOrPhoneLoginPage.enteringMobileOrEmailId(System.getenv("AMAZON_USERNAME"));
        emailOrPhoneLoginPage.clickOnContinueButton();
        passwordLoginPage.enterPassword(System.getenv("AMAZON_PASSWORD"));
        passwordLoginPage.clickOnSignInButton();
    }

    @Test(groups = {"regression"})
    public void validateNumberOfItemsInCart(){
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        CartPage cartPage = new CartPage();
        amazonHomePage.clickOnCartIcon();
        int activeCartSize = cartPage.getActiveItemsListSize();
        Assert.assertEquals(activeCartSize,2);
    }



}
