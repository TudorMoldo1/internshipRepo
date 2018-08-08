package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.CartPage;
import com.firstSerenity.pages.CheckoutPage;
import com.firstSerenity.pages.LoginPage;
import com.firstSerenity.pages.SalePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckoutSteps extends ScenarioSteps {
    @Steps
    private LoginSteps loginSteps;
    private CheckoutPage checkoutPage;
    private SalePage salePage;
    private CartPage cartPage;

    @Step
    public void login(String user, String pw)
    {
        loginSteps.login(user,pw,"http://qa1.dev.evozon.com/customer/account/");
    }

    @Step
    public void addToCart(String productName)
    {
        salePage.open();
        salePage.addToCart(productName.toUpperCase());
        cartPage.open();
        assert(cartPage.productIsPresent(productName.toUpperCase()));
    }

    @Step
    public void checkout()
    {
        checkoutPage.open();
        checkoutPage.billingInfoContinue();
        checkoutPage.chooseShippingMethod();
        checkoutPage.shippingMethodContinue();
        checkoutPage.choosePaymentMethod();
        checkoutPage.paymentMethodContinue();
        checkoutPage.reviewContinue();
    }

    @Step
    public void checkIfCompleted(){assert(checkoutPage.checkSuccessful());}
}
