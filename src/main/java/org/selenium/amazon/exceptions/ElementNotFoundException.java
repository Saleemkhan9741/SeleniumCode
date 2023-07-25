package org.selenium.amazon.exceptions;

import org.openqa.selenium.WebElement;

public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String message, WebElement webElement){
        super(webElement + message);
    }

    public static void main(String[] args) {
       
    }
}
