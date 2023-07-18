package org.selenium.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageInitializer{

    @FindBy(xpath = "//div[@data-itemtype='active']")
    private List<WebElement> activeItemsList;

    public int getActiveItemsListSize(){
        return activeItemsList.size();
    }
}
