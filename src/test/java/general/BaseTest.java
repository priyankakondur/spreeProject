package general;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
@Listeners(general.Listeners.class)
    public class BaseTest  {
        public  static WebDriver driver;

        @BeforeMethod
        public void setDriver() throws IOException {
            System.setProperty("webdriver.chrome.driver", "/Users/priyankakondur/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String url = LibraryClass.getConfigProperties("/Users/priyankakondur/Desktop/MyProjectsPOM/mavenProject/src/configurationfile.properties", "URL");
            System.out.println(url);
            driver.get(url);
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

        public void takeScreenshot(String testName) throws IOException {
                Date d = new Date();
                TakesScreenshot ts = (TakesScreenshot) driver;
                File srcFile = ts.getScreenshotAs(OutputType.FILE);
                File destFile = new File("/Users/priyankakondur/Desktop/My Projects/mavenSpreeProject/src/screenshots/" + d + testName+"_screenshot.png");
                Files.copy(srcFile, destFile);
            }
        }




