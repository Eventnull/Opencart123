package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.Myaccount_page;
import testBase.Baseclass;
import utilities.DataProviders;

public class tc003_loginDDT extends Baseclass {
    
    private static final Logger logger = LogManager.getLogger(tc003_loginDDT.class);
    
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void login_ddt(String email, String pwd, String exp) {
        try {
            logger.info("......Started testcase 2 .........");

            Home_page hp = new Home_page(driver);
            hp.clickMyaccount();
            hp.clickLogin();

            // LoginPage
            Login_page lp = new Login_page(driver);
            lp.Email(email);
            lp.Password(pwd);
            lp.Login();

            // MyAccount Page
            Myaccount_page map = new Myaccount_page(driver);
            boolean targetpage = map.Img();

            // Validate login result
            if (exp.equalsIgnoreCase("valid")) {
                if (targetpage) {
                    Assert.assertTrue(true);
                    map.logoutclick();  // Logout after successful login
                } else {
                    Assert.fail("Expected valid login but login failed.");
                }
            } else if (exp.equalsIgnoreCase("invalid")) {
                if (targetpage) {
                    map.logoutclick();
                    Assert.fail("Expected login failure but login was successful.");
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            logger.error("Test case failed due to exception: ", e);
            Assert.fail("Test case encountered an exception.");
        }

        logger.info("......Finished testcase 2 .........");
    }
}
