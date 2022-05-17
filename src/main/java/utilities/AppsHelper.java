package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.IMDB;
import pages.WIKI;

public class AppsHelper {
    public static String tool= PropertyManager.getPropertyValue("tool").toLowerCase();

    public WIKI wiki = new WIKI();
    public IMDB imdb = new IMDB();

    /**
     *
     * @return choose the type of browser
     * @throws Exception
     */
    public WebDriver openBrowser() throws Exception {
        System.out.println("========== launching browser =======");

        WebDriver driver = null;

        String browser=PropertyManager.getPropertyValue("browser").toLowerCase();

        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;

            case "firefox":
                WebDriverManager.edgedriver().setup();
                driver=new FirefoxDriver();
                return driver;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                return driver;

            default:
                throw new Exception("Unable to create Selenium Client, invalid browser specified");
        }
    }

    /**
     *
     * @param driver
     * @param url
     * launch web browser
     */

    public void launch(WebDriver driver, String url) throws Exception {
        switch(tool) {
            case "selenium":
                launchApplication(driver,url);
                break;

            default:
                throw new Exception("Unable to create Driver Client, invalid Tool specified");
        }
    }

    public void launchApplication(WebDriver driver,String url) {
        driver.get(url);
    }
}
