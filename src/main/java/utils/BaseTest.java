package utils;


import com.github.javafaker.Faker;
import configs.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pojo.User;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static configs.TestConfig.*;

public class BaseTest {
    protected static Faker faker = new Faker(new Locale(LOCALE_FOR_TEST));
    protected WebDriver driver;
    protected HomePage homePage;
    protected User user;

    @Before
    public void initTest() {
        RestAssured.baseURI = HOME_PAGE_URL;

        WebDriverManager.chromedriver().setup();
        switch (TestConfig.TARGET_BROWSER) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", YANDEX_BROWSER_CHRONIUM_DRIVER_PATH);
                ChromeOptions options = new ChromeOptions();
                options.setBinary(YANDEX_BROWSER_EXE_PATH);
                driver = new ChromeDriver(options);
                break;
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.get(HOME_PAGE_URL);

        homePage = new HomePage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
