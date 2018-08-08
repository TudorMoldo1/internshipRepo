package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class CheckoutPage extends PageObject {

    @FindBy(css = "#billing-buttons-container .button")
    WebElementFacade continueButtonBilling;

    @FindBy(css = "#s_method_freeshipping_freeshipping")
    WebElementFacade radioButtonShipping;

    @FindBy(css="#shipping-method-buttons-container .button")
    WebElementFacade continueButtonShipping;

    @FindBy(css = "#p_method_cashondelivery")
    WebElementFacade radioButtonPayment;

    @FindBy(css="#payment-buttons-container .button")
    WebElementFacade continueButtonPayment;

    @FindBy(css=".button.btn-checkout")
    WebElementFacade continueButtonReview;

    @FindBy(css=".sub-title")
    WebElementFacade success;

    @FindBy(css="#billing:use_for_shipping_yes")
    WebElementFacade billingRadioButton;

    public void billingInfoContinue()
    {
        waitFor(continueButtonBilling);
        System.out.println(continueButtonBilling.getText());
       //billingRadioButton.click();
        continueButtonBilling.click();

    }

    public void chooseShippingMethod()
    {
            waitFor(radioButtonShipping);
            radioButtonShipping.click();
    }

    public void shippingMethodContinue()
    {
            continueButtonShipping.click();
    }

    public void choosePaymentMethod()
    {
        waitFor(continueButtonPayment);
        radioButtonPayment.click();

    }

    public void paymentMethodContinue()
    {
        continueButtonPayment.click();
    }

    public void reviewContinue()
    {
        waitFor(continueButtonReview);
        continueButtonReview.click();
    }

    public boolean checkSuccessful()
    {
        waitFor(success);
        return success.getText().contains("Thank you for your purchase!".toUpperCase());
    }
}
