package pages;

import driverclients.DriverClient;
import org.openqa.selenium.WebDriver;

/**
 * @author Harundas
 * WIKI page object model
 */

public class WIKI {

    public WIKI() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    DriverClient client = new DriverClient();

    String wikiReleaseDate = "xpath=//table[@class='infobox vevent']//tr[12]//li";
    String wikiOriginCountry = "xpath=//table[@class='infobox vevent']//tr[14]//td";

    public String getWikiReleaseDate(WebDriver driver) {
        return client.getWebElement(driver, wikiReleaseDate).getText();
    }

    public String getWikiOriginCountry(WebDriver driver) {
        return client.getWebElement(driver, wikiOriginCountry).getText();
    }

}
