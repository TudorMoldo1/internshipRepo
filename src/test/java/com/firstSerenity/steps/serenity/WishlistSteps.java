package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.WishlistPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class WishlistSteps extends ScenarioSteps {
    private WishlistPage wishlistPage;

    @Step
    public void deleteProductFromWishlist(String productName){wishlistPage.deleteProductFromWishlist(productName);}

    @Step
    public void isProductPresent(String productName){assert(wishlistPage.isProductPresent(productName));}

    @Step
    public void openPage(){wishlistPage.open();}

    @Step
    public void productNotPresent(String productName){assert(wishlistPage.productNotPresent(productName));}
}
