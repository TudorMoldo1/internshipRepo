package com.firstSerenity.tests;

import com.firstSerenity.steps.serenity.HomepageSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.steps.serenity.CartSteps;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test07_Cart.csv",separator= Constants.CSV_SEPARATOR)
public class CartTest extends BaseTest {



    @Steps
    private CartSteps cartSteps;
    private HomepageSteps homepageSteps;
    private String categoryName, subcategoryName, productName;

    @Test
    public void testAddToCart()
    {
        cartSteps.login();
        cartSteps.addToCart("Park Row Throw".toUpperCase());
        cartSteps.checkIfPresent("Park Row Throw".toUpperCase());
    }

    @Test
    public void testDeleteFromCart()
    {
        cartSteps.login();
        cartSteps.addToCart("Park Row Throw".toUpperCase());
        cartSteps.emptyCart();
    }

    @Test
    public void addRandomToCart()
    {
        cartSteps.addRandomProductToCart();
    }

    @Test
    public void getProductAndAddToCart()
    {
        cartSteps.addProductWithParameters(categoryName,subcategoryName,productName);
        cartSteps.checkIfPresent(productName);
    }

    @Test
    public void testSubtotalsEqualsTotal()
    {
        cartSteps.login();
        cartSteps.openPage();
        cartSteps.checkSubtotalsEqualsTotal();
    }
}
