package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {

    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Identification
    By txtUserName = By.xpath("//input[@placeholder='Username']");
    By txtPass = By.name("password");
    By btnLogin = By.tagName("button");
    By lbluserdropdown = By.cssSelector(".oxd-userdropdown-name");
    By btnLogout = By.partialLinkText("Logo");

    public void enteruserName(String user) {
        driver.findElement(txtUserName).clear();
        driver.findElement(txtUserName).sendKeys(user);
        logger.info("Entered username: " + user);
    }

    public void enterpassword(String pwd) {
        driver.findElement(txtPass).sendKeys(pwd);
        logger.info("Entered password");
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
        logger.info("Clicked login button");
    }

    public void verifyApplicationURL(String expValue) throws Exception {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains(expValue), "URL did not contain: " + expValue);
        logger.info("URL validation passed: contains " + expValue);
    }

    public void clickuserDropdown() {
        driver.findElement(lbluserdropdown).click();
        logger.info("Clicked on user dropdown");
    }

    public void clickLogoutButton() {
        driver.findElement(btnLogout).click();
        logger.info("Clicked on logout button");
    }

    public void login(String user, String pass) {
        enteruserName(user);
        enterpassword(pass);
        clickLoginButton();
        logger.info("Performed login action");
    }
}