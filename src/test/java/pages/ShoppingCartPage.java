package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    //declaration
    @FindBy(className = "cart-item-delete>a")
    private WebElement deleteFirstItemInCart;
    @FindBy(xpath="//h1[text()='Shopping Cart']")
    private WebElement shoppingCartMessage;
    @FindBy(xpath = "//input[@value='Empty Cart']")
    private WebElement emptyCartButton;
    @FindBy(xpath = "//a[text()='Continue shopping']")
    private WebElement continueShoppingButton;
    @FindBy(xpath="//*[@class='warning cart-total']//following::td[2]")
    private WebElement cartTotalAmount;
    @FindBy(xpath = "//*[text()='Your cart is empty']")
    private WebElement cartEmptyMessage;

    // initialization
    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //utilization
    public String validateCartAmount(){
        String currentCartAmount = cartTotalAmount.getText();
        return currentCartAmount;
    }
    public void deleteAllItemsFromCart(){
        emptyCartButton.click();
    }
    public void getCartTotalAmount(){
        String cartamount = cartTotalAmount.getText();
        System.out.println("total cart amount: " +cartamount);

    }
    public String validateEmptyCartMessage(){
        String cartEmpty = cartEmptyMessage.getText();
        return cartEmpty;
    }
}
