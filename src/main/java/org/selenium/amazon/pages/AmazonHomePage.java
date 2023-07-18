package org.selenium.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends PageInitializer{

    @FindBy(xpath = "//span[@class='nav-line-2 ']")
    private WebElement helloSignInAccount;

    @FindBy(xpath = "//div[@id='nav-cart-text-container']")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
    private WebElement signInIcon;

    public void clickOnHelloSignInAccount(){
        doubleClick(helloSignInAccount,"Clicking on hello Sign In Account link");
    }

    public void moveToHelloSignInAccount(){
        hoverOverAElement(helloSignInAccount);
    }

    public void clickOnCartIcon(){
        doubleClick(cartIcon,"Clicking on cart Icon");
    }

    public void clickOnSignInIcon(){
        clickOnElementUsingJS(signInIcon);
    }

    public void moveToSignInButton(){
        hoverOverAElement(signInIcon);
    }

}
