package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.DashboardPage;
import com.firstSerenity.pages.EditAddressPage;
import com.firstSerenity.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class EditAddressSteps extends ScenarioSteps {
    private DashboardPage dashboardPage;
    private EditAddressPage editAddressPage;

    @Steps
    private LoginSteps loginSteps;

    @Step
    public void setInputFields(String firstName, String lastName, String telephone, String street, String city, String zipCode, String region, String country)
    {
        editAddressPage.setFirstNameField(firstName);
        editAddressPage.setLastNameField(lastName);
        editAddressPage.setTelephoneField(telephone);
        editAddressPage.setStreetField(street);
        editAddressPage.setCityField(city);
        editAddressPage.setPostalCodeField(zipCode);
        editAddressPage.setRegionDropdown(region);
        editAddressPage.setCountryDropdown(country);
    }

    @Step
    public void clickSave(){editAddressPage.clickSave();}

    @Step
    public void errorMessageDisplayed(){assert(editAddressPage.errorAppeared());}

    @StepGroup
    public void changeAddress(String firstName, String lastName, String telephone, String street, String city, String zipCode, String region, String country, String email, String pw)
    {
        loginSteps.openPage();
        loginSteps.setCredentials(email,pw);
        loginSteps.clickLogin();
        dashboardPage.open();
        dashboardPage.clickEditBillingAddress();
        setInputFields(firstName,lastName,telephone,street,city,zipCode,region,country);
        clickSave();
        errorMessageDisplayed();
    }
}
