
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class SearchUserPage {

    WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(SearchUserPage.class);

    // Locators
    By searchUsername = By.xpath("//label[text()='Username']/following::input[1]");
    By clickSearch = By.xpath("//button[@type='submit' and contains(@class, 'orangehrm-left-space')]");
    

    public SearchUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods
    public void enterUsername(String username) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsername)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsername)).sendKeys(username);
        logger.info("Entered username for search: {}", username);
    }

//    public void clickSearch() {
//        wait.until(ExpectedConditions.elementToBeClickable(clickSearch)).click();
//        logger.info("Clicked Search button");
//       
//    }
    
    public void clickSearch() {
        // Wait until the loader disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader")));
        
        // Now wait for and click the button
        wait.until(ExpectedConditions.elementToBeClickable(clickSearch)).click();
        logger.info("Clicked Search button");
    }

    public void SearchUser(String username) {
        enterUsername(username);
        clickSearch();
        logger.info("SearchUser action completed successfully for username: {}", username);
    }
}




