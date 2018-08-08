package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@DefaultUrl("http://qa1.dev.evozon.com/customer/account/")
public class EditAddressPage extends PageObject {
    @FindBy(css = "#firstname")
    private WebElementFacade firstNameField;

    @FindBy(css = "#zip")
    private WebElementFacade postalCodeField;

    @FindBy(css = "#lastname")
    private WebElementFacade lastNameField;

    @FindBy(css = "#telephone")
    private WebElementFacade telephoneField;

    @FindBy(css = "#street_1")
    private WebElementFacade streetField;

    @FindBy(css = "#city")
    private WebElementFacade cityField;

    @FindBy(css="button[title*=\"Save Address\"]")
    private WebElementFacade saveButton;

    @FindBy(css=".validation-advice")
    private WebElementFacade errorMessage;

    public void setFirstNameField(String name)
    {
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void setPostalCodeField(String zip)
    {
        postalCodeField.clear();
        postalCodeField.sendKeys(zip);
    }

    public void setLastNameField(String name)
    {
        lastNameField.clear();
        lastNameField.sendKeys(name);
    }

    public void setTelephoneField(String phone)
    {
        telephoneField.clear();
        telephoneField.sendKeys(phone);
    }
    public void setCityField(String city)
    {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void setStreetField(String address)
    {
        streetField.clear();
        streetField.sendKeys(address);
    }

    public void setRegionDropdown(String region)
    {
        Select regionDropdown=new Select(getDriver().findElement(By.cssSelector("#region_id")));
        regionDropdown.selectByVisibleText("Please select region, state or province");
        regionDropdown.selectByVisibleText(region);
    }

    public void setCountryDropdown(String country)
    {
        Select countryDropdown=new Select(getDriver().findElement(By.cssSelector("#country")));
        countryDropdown.selectByVisibleText("");
        countryDropdown.selectByVisibleText(country);
    }

    public void clickSave()
    {
        saveButton.click();
    }

    public boolean errorAppeared(){return errorMessage.isDisplayed();}

}
