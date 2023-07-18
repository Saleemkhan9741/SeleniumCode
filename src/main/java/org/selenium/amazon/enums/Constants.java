package org.selenium.amazon.enums;

public enum Constants {

    BROWSER("browser"),
    URL("base.url"),
    CLOSE("close"),
    HEADLESS("headless");

    private String property;
    Constants(String property) {
        this.property = property;
    }

    public String getProperty(){
        return property;
    }
}
