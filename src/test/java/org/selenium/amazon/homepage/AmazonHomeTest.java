package org.selenium.amazon.homepage;

import org.selenium.amazon.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AmazonHomeTest extends BaseTest{

    @Test(groups = {"regression"})
    public void loginToAmazon(){
        amazonHomePage.clickOnHelloSignInAccount();
        emailOrPhoneLoginPage.enteringMobileOrEmailId("saleemkhan9741@gmail.com");
        passwordLoginPage.enterPassword("Saleemmulla@123");
    }

    @Test(groups = {"regression"})
    public void validateNumberOfItemsInCart(){
        System.out.println("Running test " + Arrays.stream(getClass().getMethods()).findFirst().get().getName());
        amazonHomePage.clickOnCartIcon();
        int activeCartSize = cartPage.getActiveItemsListSize();
        Assert.assertEquals(activeCartSize,2);
    }
}
