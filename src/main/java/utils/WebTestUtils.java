package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTestUtils {

    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}