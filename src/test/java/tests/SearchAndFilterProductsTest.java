package tests;

import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchAndFilterProductsTest extends BaseTest {
    @Test
    public void SearchProducts(){
        HomePage hp = new HomePage(driver);
        hp.searchUsingSearchTextBox("Ruby");
        hp.allProductsMatchingBrandName("Ruby");
        hp.searchUsingSearchTextBox("Apache");
        hp.allProductsMatchingBrandName("Apache");
    }
@Test
    public void FilterUsingCategoryOrBrandAndPrice()  {
    HomePage hp = new HomePage(driver);
    hp.filterUsingCategoriesAndBrands("Bags");
    hp.filterUsingCategoriesAndBrands(" $15.00 - $18.00 " );
    boolean b = hp.allProductsMatchingPriceRange(15.00,18.00);
    Assert.assertEquals(b,true);
}
}
