package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utility.Constant;
import org.testng.Assert;

public class LoginTest extends TestBase {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void VerifyAdminMenu() throws Exception {
        logger.info("Starting VerifyAdminMenu test");

        lp2.login(Constant.hrmAdminuser, Constant.hrmAdminpass);
        logger.info("Logged in with admin credentials");

        // validation
        lp2.verifyApplicationURL("dashboard");
        logger.info("Verified dashboard URL");

        // click on Menu
        me2.clickAdminMenu();
        logger.info("Clicked on Admin menu");

        Thread.sleep(3000);
        ap2.addUser("Admin", "Enabled");
        logger.info("Added user with role Admin and status Enabled");

//        Thread.sleep(1000);
//        sp2.SearchUser("Rajat");
//        logger.info("Searched for user Rajesh");

        Thread.sleep(3000);
        lp2.clickuserDropdown();
        lp2.clickLogoutButton();
        logger.info("Logged out successfully");

        // validation
        lp2.verifyApplicationURL("login");
        logger.info("Verified login URL after logout");

        logger.info("VerifyAdminMenu test completed successfully");
    }
}
