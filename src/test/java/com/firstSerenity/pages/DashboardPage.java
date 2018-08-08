package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/customer/account/")
public class DashboardPage extends PageObject {
    @FindBy(css = "div.box-account:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2)")
    private WebElementFacade editBillingAddress;


    public void clickEditBillingAddress()
    {
        editBillingAddress.click();
    }

}
