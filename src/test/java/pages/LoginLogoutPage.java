package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLogoutPage extends  BasePage{
    //declaration
    @FindBy(id = "spree_user_email")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement submitLoginButton;
    @FindBy(xpath = "//*[text()='Logged in successfully']")
    private WebElement loginSuccessMessage;
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement submitLogoutButton;
    @FindBy(xpath = "//*[text()='Signed out successfully.']")
    private WebElement logoutSuccessMessage;
    @FindBy(id = "link-to-login")
    private WebElement loginButton;
    @FindBy(linkText = "My Account")
    private WebElement myAccountButton;

    // initialization
    public LoginLogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //utilization
    public void setEmailAndPasswordAndLogin(String email,String password) {
        loginButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }
    public String verifyLoginSuccessMessage() {
        String successMessage = loginSuccessMessage.getText();
        return successMessage;
    }

    public void clickLogoutButton() {
        submitLogoutButton.click();
    }

    public String verifyLogoutSuccessMessage() {
        String successMessage = logoutSuccessMessage.getText();
        return successMessage;
    }

}


