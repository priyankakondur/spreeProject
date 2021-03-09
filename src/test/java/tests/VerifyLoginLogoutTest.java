package tests;

import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginLogoutPage;

import java.io.IOException;
@Listeners(general.Listeners.class)
public class VerifyLoginLogoutTest extends BaseTest {

    @Test
        public void LoginUsingEmailAndPassword() throws IOException {
            LoginLogoutPage lp = new LoginLogoutPage(driver);
            //login
            lp.setEmailAndPasswordAndLogin("priyanka.jkondur@gmail.com","welcome123");
            String message = lp.verifyLoginSuccessMessage();
            Assert.assertEquals(message,"Logged in successfully");
            //logout
            lp.clickLogoutButton();
            String logoutMessage = lp.verifyLogoutSuccessMessage();
            Assert.assertEquals(logoutMessage, "Signed out successfully.");

        }

    }


