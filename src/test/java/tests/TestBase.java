package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("http://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
