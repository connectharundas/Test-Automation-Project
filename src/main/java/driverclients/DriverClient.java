package driverclients;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Harundas
 */

public class DriverClient {

    /**
     *
     * @param locatorString
     * @return  locators in Selenium WebDriver
     */

    public By customLocator(String locatorString) {

        String[] locator = locatorString.split("=", 2);

        switch (locator[0].toLowerCase())
        {
            case "id":
                return By.id(locator[1]);

            case "name":
                return By.name(locator[1]);

            case "xpath":
                return By.xpath(locator[1]);

            case "tagname":
                return By.tagName(locator[1]);

            case "linktext":
                return By.linkText(locator[1]);

            case "partiallinktext":
                return By.partialLinkText(locator[1]);

            default:
                return By.xpath(locator[1]);
        }
    }


    /**
     *
     * @param driver
     * @param locatorString
     * @return webelement
     */


    public WebElement getWebElement(WebDriver driver, String locatorString) {
        WebElement element = null;
        try {
            element = driver.findElement(customLocator(locatorString));
        } catch (ElementClickInterceptedException e) {
            element = driver.findElement(customLocator(locatorString));
        }
        return element;
    }


    /**
     *
     * @param driver
     * @param locatorString
     * @param textValue
     * @throws Exception
     */

    public void enterText(WebDriver driver, String locatorString, String textValue) throws Exception {
        try {
            driver.findElement(customLocator(locatorString)).sendKeys(textValue);
        } catch (ElementClickInterceptedException e) {
            throw new Exception("Unable to create Driver Client, invalid Tool specified");
        }
    }


    /**
     *
     * @param driver
     * @param locatorString
     * @throws Exception
     */

    public void click(WebDriver driver, String locatorString) throws Exception {
        try {
            Thread.sleep(3000);
            driver.findElement(customLocator(locatorString)).click();
        } catch (ElementClickInterceptedException e) {
            throw new Exception("Unable to create Driver Client, invalid Tool specified");
        }
    }
}
