package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import constants.urls.ZigzagTestingUrls;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return options;
    }
    
    // goHome function for Homework3.2
    // public void goHome() {
    //     driver = new ChromeDriver(getChromeOptions());
    //
    //     driver.manage().window().maximize();
    //     driver.get(ZigzagTestingUrls.pageUrl);
    // }

    // goHome function for Homework3.3
    @BeforeMethod
    public void goHome() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), capabilities);

        driver.manage().window().maximize();
        driver.get(ZigzagTestingUrls.pageUrl);
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String screenshotName = "test_failure_" + timestamp + ".png";
            Path screenshotPath = Paths.get("screenshots", screenshotName);

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(screenshotPath.getParent());
            FileHandler.copy(screenshotFile, screenshotPath.toFile());
        }
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
}
