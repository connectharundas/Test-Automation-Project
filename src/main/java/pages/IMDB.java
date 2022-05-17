package pages;

import driverclients.DriverClient;
import org.openqa.selenium.WebDriver;

/**
 * @author Harundas
 * IMDB page object model
 */

public class IMDB {
    DriverClient client = new DriverClient();

    String imdbReleaseDate = "xpath=//li[@data-testid='title-details-releasedate']//a[contains(@class,'content')]";
    String imdbOriginCountry = "xpath=//li[@data-testid='title-details-origin']//a[contains(@class,'content')]";
    String searchBar = "xpath=//input[@name='q']";
    String clickkey = "xpath=//div[text()='Pushpa: The Rise - Part 1']";


    public String getImdbReleaseDate(WebDriver driver) {
        return client.getWebElement(driver, imdbReleaseDate).getText();
    }

    public String getImdbOriginCountry(WebDriver driver) {
        return  client.getWebElement(driver, imdbOriginCountry).getText();
    }

    public void searchMovie(WebDriver driver, String textValue) throws Exception {
        client.enterText(driver, searchBar, textValue);
    }

    public void clickMovie(WebDriver driver) throws Exception {
        client.click(driver, clickkey);
    }
}

