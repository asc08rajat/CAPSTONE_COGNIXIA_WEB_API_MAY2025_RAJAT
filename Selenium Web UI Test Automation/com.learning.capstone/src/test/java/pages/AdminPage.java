package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdminPage {

    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(AdminPage.class);

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    By lblAdmin = By.xpath("//span[text()='Admin']");

    public void clickAdminMenu() {
        driver.findElement(lblAdmin).click();
        logger.info("Clicked Admin menu");
    }
}