package com.firstSerenity.tests;

import com.firstSerenity.steps.serenity.SearchSteps;
import com.firstSerenity.steps.serenity.WishlistSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test10_Wishlist.csv",separator=Constants.CSV_SEPARATOR)
public class WishlistTest extends BaseTest {
    @Steps
    private WishlistSteps wishlistSteps;
    @Steps
    private SearchSteps searchSteps;
    private String productName;

    @Test
    @Title("Test10_WishlistAddProduct")
    public void wishlistAddProduct()
    {
        searchSteps.login();
        searchSteps.searchFromHomepage(productName);
        searchSteps.clickAddToWishlistButton();
        wishlistSteps.openPage();
        wishlistSteps.isProductPresent(productName);
    }

    @Test
    @Title("Test11_WishlistRemoveProduct")
    public void wishlistRemoveProduct()
    {
        searchSteps.login();
        wishlistSteps.openPage();
        wishlistSteps.deleteProductFromWishlist(productName);
        wishlistSteps.productNotPresent(productName);
    }
}
