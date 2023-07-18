package org.selenium.amazon.pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.amazon.pages.PageInitializer;

import java.util.List;

public class CartPage extends PageInitializer {

    @FindBy(xpath = "//div[@data-itemtype='active']")
    private List<WebElement> activeItemsList;

    public int getActiveItemsListSize(){
        return activeItemsList.size();
    }
}
