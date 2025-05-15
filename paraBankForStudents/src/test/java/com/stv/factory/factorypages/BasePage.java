package com.stv.factory.factorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    private final By ALLOW_ALL_BUTTON = By.id("onetrust-accept-btn-handler");

    public void clickOnAllowCookiesIfVisible() {
        try {
            WebElement allowCookiesButton = driver.findElement(ALLOW_ALL_BUTTON);
            if (allowCookiesButton.isDisplayed())
                allowCookiesButton.click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }
}