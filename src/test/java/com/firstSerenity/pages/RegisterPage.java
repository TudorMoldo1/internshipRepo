package com.firstSerenity.pages;

import com.firstSerenity.utils.Constants;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl(Constants.BASE_URL+"/customer/account/create/")
public class RegisterPage extends PageObject {
    @FindBy(css="#firstname")
    private WebElementFacade firstNameField;

    @FindBy(css="#lastname")
    private WebElementFacade lastNameField;

    @FindBy(css="#email_address")
    private WebElementFacade emailField;

    @FindBy(css="#password")
    private WebElementFacade passwordField;

    @FindBy(css="#confirmation")
    private WebElementFacade confirmationField;

    public void setFirstNameField(String firstName) { firstNameField.sendKeys(firstName); }

    public void setLastNameField(String lastName){lastNameField.sendKeys(lastName);}

    public void setEmailField(String email){emailField.sendKeys(email);}

    public void setPasswordField(String password){passwordField.sendKeys(password);}

    public void setConfirmationField(String password){confirmationField.sendKeys(password);}

    public void clickRegister()
    {
        WebElement registerButton=getDriver().findElement(By.cssSelector("button[title*=\"Register\"]"));
        registerButton.click();
    }

    public boolean checkIfErrorDisplayed()
    {
        return getDriver().findElement(By.cssSelector(".validation-advice")).isDisplayed();
    }

}
