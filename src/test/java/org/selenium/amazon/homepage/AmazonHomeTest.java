package org.selenium.amazon.homepage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.selenium.amazon.BaseTest;
import org.selenium.amazon.pages.AmazonHomePage;
import org.selenium.amazon.pages.CartPage;
import org.selenium.amazon.pages.EmailOrPhoneLoginPage;
import org.selenium.amazon.pages.PasswordLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AmazonHomeTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(AmazonHomeTest.class);

    @Test(groups = {"regression"})
    public void loginToAmazon(){
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        EmailOrPhoneLoginPage emailOrPhoneLoginPage = new EmailOrPhoneLoginPage();
        PasswordLoginPage passwordLoginPage = new PasswordLoginPage();
        amazonHomePage.moveToHelloSignInAccount();
        amazonHomePage.clickOnHelloSignInAccount();
        emailOrPhoneLoginPage.enteringMobileOrEmailId("saleemkhan9741@gmail.com");
        emailOrPhoneLoginPage.clickOnContinueButton();
        passwordLoginPage.enterPassword("Saleemmulla@123");
        passwordLoginPage.clickOnSignInButton();
    }

    @Test(groups = {"regression"})
    public void validateNumberOfItemsInCart(){
        System.out.println("Running test " + Arrays.stream(getClass().getMethods()).findFirst().get().getName());
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        CartPage cartPage = new CartPage();
        amazonHomePage.clickOnCartIcon();
        int activeCartSize = cartPage.getActiveItemsListSize();
        Assert.assertEquals(activeCartSize,2);
    }
}
