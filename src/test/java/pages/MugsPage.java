package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MugsPage extends BasePage{
        //declaration
        @FindBy(id = "home-link")
        private WebElement homeButton;
        @FindBy(xpath = "//a[text()='Mugs']")
        private WebElement mugsButton;
        @FindBy(className = "btn btn-primary")
        private WebElement searchFilterForPrice;
        @FindBy(id="add-to-cart-button")
        private WebElement addToCartButton;
        @FindBy(xpath = "//a[text()='Rails']")
        private WebElement railsButton;
        @FindBy(xpath= "//h4[text()=' Price Range ']/following-sibling::ul/li[2]")
        private WebElement priceRange10_15;
        @FindBy(xpath="//*[text()='Ruby on Rails Mug']")
        private WebElement rubyOnRailsMugItem;

        // initialization
        public MugsPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }
        //utilization
        public void addMugItemToCart(){
            homeButton.click();
            mugsButton.click();
            rubyOnRailsMugItem.click();
            addToCartButton.click();

        }


    }


