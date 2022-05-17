import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AppsHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Harundas
 *
 */


public class AppTest extends AppsHelper {
    String valueWikiReleaseDate;
    String valueWikiOriginCountry;
    String valueImbdReleaseDate;
    String valueImbdOriginCountry;
    WebDriver driver;

    @BeforeMethod
    public void start() throws Exception {
        driver = openBrowser();
    }

    @Test(priority = 0)
    public void wiki() {
        try {
           launch(driver, "https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
           valueWikiReleaseDate = wiki.getWikiReleaseDate(driver);
           valueWikiOriginCountry = wiki.getWikiOriginCountry(driver);

           System.out.println("valueWikiReleaseDate: " + valueWikiReleaseDate);
           System.out.println("valueWikiOriginCountry: " + valueWikiOriginCountry);

            DateFormat format = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
            valueWikiReleaseDate = format.parse(valueWikiReleaseDate).toString();

            System.out.println(valueWikiReleaseDate);

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }


    @Test(priority = 1)
    public void imdb() {
        try {
            launch(driver, "https://www.imdb.com/");
            imdb.searchMovie(driver, "Pushpa: the rise");
            imdb.clickMovie(driver);

            valueImbdReleaseDate = imdb.getImdbReleaseDate(driver);
            valueImbdOriginCountry = imdb.getImdbOriginCountry(driver);

            System.out.println("valueImbdReleaseDate : " + valueImbdReleaseDate);
            System.out.println("valueImbdOriginCountry: " + valueImbdOriginCountry);


            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            valueImbdReleaseDate= format.parse(valueImbdReleaseDate).toString();
           System.out.println(valueImbdReleaseDate);

            if(valueImbdReleaseDate.equals(valueImbdReleaseDate) && valueImbdOriginCountry.equals(valueWikiOriginCountry)) {
                Assert.assertTrue(true,"Release dates and Release origin on two sources are same");
            }
            else {
                Assert.assertTrue(false,"Release dates and Release origin on two sources are NOT same");
            }
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }
}
