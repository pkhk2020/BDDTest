package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The type Library.
 */
public class Library extends Base{

    /**
     * Expected wait web element.
     *
     * @param ele  the ele
     * @param time the time
     * @return the web element
     */
    public WebElement expectedWait(WebElement ele,int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(ele));//visibilityOfElementLocated((By) ele));//(By.xpath("//h2[text()='My wishlist']")));
        return element;
    }

    /**
     * Expected wait web element.
     *
     * @param by   the by
     * @param time the time
     * @return the web element
     */
    public WebElement expectedWait(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(by));
        return element;


    }

}
