package tests;

import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginLogoutPage;
import pages.MugsPage;
import pages.ShoppingCartPage;

public class AddMugItemsAndEmptyCartTest extends BaseTest {
    @Test
    public void AddMugItemsAndEmptyCart(){
        LoginLogoutPage lp = new LoginLogoutPage(driver);
        lp.setEmailAndPasswordAndLogin("priyanka.jkondur@gmail.com", "welcome123");
        MugsPage mp = new MugsPage(driver);
        mp.addMugItemToCart();
        mp.addMugItemToCart();
        mp.addMugItemToCart();
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        cart.getCartTotalAmount();
        cart.deleteAllItemsFromCart();
        String cartEmptyMessage = cart.validateEmptyCartMessage();
        Assert.assertEquals(cartEmptyMessage, "Your cart is empty");
    }
}
