package org.selenium.hyrtutorials.frames;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.amazon.driverutils.Driver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchToParticularTab {

    @Test(groups = "smoke")
    public void openALinkInNewTab(){
        WebDriver currentDriver = Driver.getInstance().getWebdriver();
        String parentWindowId = currentDriver.getWindowHandle();
        WebElement menLink = currentDriver.findElement(By.xpath("//a[@title='MEN']"));
        WebElement womenLink = currentDriver.findElement(By.xpath("//a[@title='WOMEN']"));
        WebElement kidsLink = currentDriver.findElement(By.xpath("//a[@title='KIDS']"));
        Actions actions = new Actions(currentDriver);
        actions.keyDown(Keys.COMMAND).moveToElement(menLink).click().perform();
        actions.keyDown(Keys.COMMAND).moveToElement(womenLink).click().perform();
        actions.keyDown(Keys.COMMAND).moveToElement(kidsLink).click().perform();
        Set<String> windowHandles = currentDriver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>(windowHandles);
        switchToSpecificWindow(currentDriver,"MEN",windowsList);
        currentDriver.switchTo().window(parentWindowId);
        closeAllTabsOtherThanParentTab(currentDriver,parentWindowId,windowsList);
    }

    private void closeAllTabsOtherThanParentTab(WebDriver currentDriver, String parentId, ArrayList<String> windowsList) {
        windowsList.stream().filter(x->!x.equals(parentId)).forEach(x->{
            currentDriver.switchTo().window(x).close();
        });
    }

    public void switchToSpecificWindow(WebDriver currentDriver, String windowText, List<String> windowHandles){
        for (String windowHandle : windowHandles) {
            String title = currentDriver.switchTo().window(windowHandle).getTitle();
            if (title.contains(windowText)) {
                return;
            }
        }
    }
}
