package com.firstSerenity.tests;

import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.steps.serenity.CheckoutSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class CheckoutTest extends BaseTest {


    @Steps
    private CheckoutSteps checkoutSteps;

    @Test
    public void testFromLoginToCheckout()
    {
        checkoutSteps.login("tudor.moldovanu@evozon.com","1234567");
        checkoutSteps.addToCart("Park Row Throw");
        checkoutSteps.checkout();
        checkoutSteps.checkIfCompleted();
    }
}
