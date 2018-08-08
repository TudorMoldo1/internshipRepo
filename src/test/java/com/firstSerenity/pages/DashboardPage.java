package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/customer/account/")
public class DashboardPage extends PageObject {
    @FindBy(css = "a[href*=\"edit/id/105\"]")
    private WebElementFacade editBillingAddress;


    public void clickEditBillingAddress()
    {
        editBillingAddress.click();
    }

}
