package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/admin")
public class MagentoLoginPage extends PageObject {
    @FindBy(css="#username")
    private WebElementFacade username;
    @FindBy(css="#login")
    private WebElementFacade password;
    @FindBy(css=".form-button")
    private WebElementFacade loginButton;

    public void setUsername(String username) { this.username.sendKeys(username); }

    public void setPassword(String password){this.password.sendKeys(password);}

    public void clickLogin(){
        evaluateJavascript("jQuery.noConflict();");
        this.loginButton.click();
    }
}
