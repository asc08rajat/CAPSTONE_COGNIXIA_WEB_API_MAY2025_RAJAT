
package tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.AddUserPage;
import pages.AdminPage;
import pages.LoginPage;
import pages.SearchUserPage;
import utility.Constant;
import utility.ReadConfigData;

public class TestBase {

    WebDriver driver;
    LoginPage lp2;
    AdminPage me2;
    AddUserPage ap2;
    SearchUserPage sp2;

    private static final Logger logger = LogManager.getLogger(TestBase.class);

    @BeforeTest
    public void launchApp() throws Exception {
        logger.info("Launching the application");
             
        boolean isHeadless = ReadConfigData.getBoolean("headless");


        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            logger.info("Running in HEADLESS mode from config.properties");
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
        }


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Constant.hrm_appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);

        // Create page objects
        lp2 = new LoginPage(driver);
        me2 = new AdminPage(driver);
        ap2 = new AddUserPage(driver);
        sp2 = new SearchUserPage(driver);

        logger.info("Application launched and page objects initialized");
    }

    @AfterTest
    public void closeApp() throws Exception {
        Thread.sleep(3000);
        logger.info("Closing the application");
        if (driver != null) {
            driver.quit();
        }
    }
}
