package org.selenium.amazon.pages.frames;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.amazon.pages.PageInitializer;

@Getter
public class HyrTutorials extends PageInitializer {

    @FindBy(xpath = "//*[@class='frmTextBox']")
    private WebElement parentTextBox;

    @FindBy(id="frm1")
    private WebElement firstFrameElement;

    @FindBy(className = "selectnav")
    private WebElement firstFrameDropDown;

    @FindBy(id="frm2")
    private WebElement secondFrameElement;

    @FindBy(className = "selectnav1")
    private WebElement secondFrameDropDown;

    @FindBy(id="firstname")
    private WebElement secondFrameFirstNameTextBox;

    @FindBy(id="frm3")
    private WebElement thirdFrameElement;

    @FindBy(xpath="//*[@id='selectnav1']")
    private WebElement thirdFrameElementDropDown;

    public void enterNameIntoParentTextBox(String name){
        sendKeys(parentTextBox,name);
    }

    public void clearParentTextBox(){
        clear(parentTextBox);
    }

    public void enterValueIntoSecondFrameFirstNameTextBox(String name){
        sendKeys(secondFrameFirstNameTextBox, name);
    }


}
