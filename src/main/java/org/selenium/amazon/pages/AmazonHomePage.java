package org.selenium.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends PageInitializer{

    @FindBy(xpath = "//span[@class='nav-line-2 ']")
    private WebElement helloSignInAccount;

    @FindBy(xpath = "//div[@id='nav-cart-text-container']")
    private WebElement cartIcon;

    public void clickOnHelloSignInAccount(){
        click(helloSignInAccount,"Clicking on hello Sign In Account link");
    }

    public void clickOnCartIcon(){
        click(cartIcon,"Clicking on cart Icon");
    }

}
