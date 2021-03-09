package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends  BasePage {
    //declaration
    @FindBy(id = "home-link")
    private WebElement homeButton;
    @FindBy(id = "link-to-cart")
    private WebElement cartButton;
    @FindBys(@FindBy(xpath = "//h4[text()='Shop by Categories']/following-sibling::div[1]/a"))
    private List<WebElement> allCategories;
    @FindBy(id = "taxonomies")
    private WebElement categories;
    @FindBys(@FindBy(xpath = "//h4[text()='Shop by Brands']/following-sibling::div[1]/a"))
    private List<WebElement> allBrands;
    @FindBy(xpath = "//h1[text()='Mugs']")
    private WebElement mugsTitleMessage;
    @FindBy(xpath = "//h1[text()='Rails']")
    private WebElement railsTitleMessage;
    @FindBy(id = "keywords")
    private WebElement searchInputField;
    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;
    @FindBys(@FindBy(css = "*[id*=product_]"))
    private List<WebElement> products;
    @FindBy(xpath = "//h4[text()=' Price Range ']/following-sibling::ul/li")
    private List<WebElement> priceRange;
    @FindBys(@FindBy(xpath="//*[@id='taxonomies']/div/a"))
    private List<WebElement> shopByCategoriesAndBrands;
    @FindBy(css = "input[class='btn btn-primary']")
    private WebElement priceSearchButton;


    // initialization
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //utilization
    public void searchUsingSearchTextBox(String brandName) {
        searchInputField.clear();
        searchInputField.sendKeys(brandName);
        searchButton.click();
    }

    public void allProductsMatchingBrandName(String brandName) {
        for (WebElement product : products) {
            String eachCategory = product.getText();
            if (eachCategory.contains(brandName)) {
                System.out.println(eachCategory);
            }

        }
    }

    public void filterUsingCategoriesAndBrands(String name){
        for (WebElement ele :shopByCategoriesAndBrands){
            if(ele.getText().contains(name)){
                ele.click();
                break;
            }

        }
    }

    public void filterUsingPriceRange(String priceRange){
        for(WebElement price: shopByCategoriesAndBrands){
            if(price.getText().contains(priceRange)){
                price.click();
                priceSearchButton.click();
                break;
            }
        }
    }
    public boolean allProductsMatchingPriceRange(double min, double max) {
        for (WebElement product : products) {
            WebElement productPriceEle = product.findElement(By.className("price"));
            String eachPrice = productPriceEle.getText().trim().replace("$", "");
            double productPrice = (double)Double.parseDouble(eachPrice);
            if(productPrice>=min && productPrice<=max){
                return true;
            }

        }
        return false;
    }
}
