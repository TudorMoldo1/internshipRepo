package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/customer/account/login/")
public class LoginPage extends PageObject {
    @FindBy(css="#email")
    private WebElementFacade emailField;
    @FindBy(css="#pass")
    private WebElementFacade passField;
    @FindBy(css="#send2")
    private WebElementFacade loginButton;

    public void setEmail(String email)
    {
        emailField.sendKeys(email);
    }

    public void setPassword(String pw)
    {
        passField.sendKeys(pw);
    }

    public void clickLogin(){loginButton.click();}
}
