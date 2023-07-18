package org.selenium.hyrtutorials.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.selenium.BaseTest;
import org.selenium.amazon.driverutils.Driver;
import org.selenium.amazon.enums.Locators;
import org.selenium.amazon.pages.frames.HyrTutorials;
import org.selenium.amazon.utils.PageUtility;
import org.testng.annotations.Test;

public class HyrTutorialsTest extends BaseTest {

    @Test(groups = {"sanity"})
    public void practiceFrames() throws InterruptedException {
        WebDriver currentDriver = Driver.getInstance().getWebdriver();
        HyrTutorials hyrTutorials = new HyrTutorials();
        hyrTutorials.clearParentTextBox();
        hyrTutorials.enterNameIntoParentTextBox("Saleem");
        currentDriver.switchTo().frame(new PageUtility().getElementByLocator(Locators.ID,"frm1"));
        Select select1 = new Select(hyrTutorials.getFirstFrameDropDown());
        select1.selectByValue("Tech News");
        currentDriver.switchTo().defaultContent();
        currentDriver.switchTo().frame(new PageUtility().getElementByLocator(Locators.ID,"frm2"));
        Select select2 = new Select(hyrTutorials.getSecondFrameDropDown());
        select2.selectByValue("Tutorials");
        hyrTutorials.enterValueIntoSecondFrameFirstNameTextBox("Saleem");
        currentDriver.switchTo().defaultContent();
        currentDriver.switchTo().frame(new PageUtility().getElementByLocator(Locators.ID,"frm3"));
        Select select3 = new Select(hyrTutorials.getThirdFrameElementDropDown());
        select3.selectByValue("Menu");
        currentDriver.switchTo().defaultContent();
    }
}
