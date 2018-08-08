package com.firstSerenity.tests;

import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.steps.serenity.CartSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;


public class CartTest extends BaseTest {



    @Steps
    private CartSteps cartSteps;

    @Test
    public void testAddToCart()
    {
        cartSteps.login();
        cartSteps.addToCart("Park Row Throw".toUpperCase());
        cartSteps.checkIfPresent("Park Row Throw".toUpperCase());
    }

    @Test
    public void testEmptyCart()
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
}
