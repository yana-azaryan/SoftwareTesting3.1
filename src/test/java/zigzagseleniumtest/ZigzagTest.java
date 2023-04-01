package zigzagseleniumtest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ZigzagTest {
    public static WebDriver driver;
    public static String url = "https://www.zigzag.am/";

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test(priority=1)
    public void zigzagCatalogTest() {
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.cssSelector(".catalog_btn")).click();
        String catalog = driver.findElement(By.cssSelector(".list_inner")).getText();

        softAssert.assertTrue(catalog.contains("Հեռուստացույցներ, աուդիո և վիդեոտեխնիկա"));
    }

    @Test(priority=2)
    public void zigzagSearchTest() {
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.id("search")).sendKeys("Dyson");
        driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/button")).click();
        String resultPage = driver.findElement(By.className("page_inner")).getText();

        softAssert.assertTrue(resultPage.contains("Որոնման արդյունքները 'Dyson' -ի համար"));
    }

    @Test(priority=3)
    public void zigzagWrongSignInInputFormatTest() {
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.cssSelector(".sign_block")).click();
        driver.findElement(By.id("email")).sendKeys("tom");
        driver.findElement(By.id("send2")).click();

        softAssert.assertTrue(driver.findElement(By.id("email-error")).getText().contains("Խնդրում ենք մուտքագրել վավեր էլ-փոստի հասցե"));
        softAssert.assertTrue(driver.findElement(By.id("pass-error")).getText().contains("Սա պարտադիր դաշտ է:"));
    }

    @Test(priority=4)
    public void zigzagFailedSignInTest() {
        SoftAssert softAssert = new SoftAssert();

        //ToDo: comment below line when running zigzagFailedSignInTest test separately
        driver.findElement(By.className("main_logo")).click();
        driver.findElement(By.cssSelector(".sign_block")).click();
        driver.findElement(By.id("email")).sendKeys("brown@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("send2")).click();

        softAssert.assertTrue(driver.findElement(By.id("authenticationPopup")).isDisplayed());
    }

    @Test(priority=5)
    public void zigzagSuccessfulSignInTest() {
        SoftAssert softAssert = new SoftAssert();

        //ToDo: comment below line when running zigzagSuccessfulSignIn test separately
        driver.findElement(By.className("main_logo")).click();
        driver.findElement(By.cssSelector(".sign_block")).click();
        driver.findElement(By.id("email")).sendKeys("yana_azaryan@edu.aua.am");
        driver.findElement(By.id("pass")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("send2")).click();

        softAssert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Իմ հաշիվը"));
    }
}
