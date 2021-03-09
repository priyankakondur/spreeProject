package tests;

import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginLogoutPage;
import pages.MugsPage;
import pages.ShoppingCartPage;

public class AddRubyOnRailsToCartAndCheckPriceTest extends BaseTest {

    @Test
    public void AddRubyOnRailsMugToCartAndValidatePrice() {
        LoginLogoutPage lp = new LoginLogoutPage(driver);
        lp.setEmailAndPasswordAndLogin("priyanka.jkondur@gmail.com", "welcome123");
        MugsPage mp = new MugsPage(driver);
        mp.addMugItemToCart();
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        String cartValueAfterAddingMugItem = cart.validateCartAmount();
        System.out.println(cartValueAfterAddingMugItem);
        Assert.assertEquals(cartValueAfterAddingMugItem,"$13.99");
        cart.deleteAllItemsFromCart();
    }
}