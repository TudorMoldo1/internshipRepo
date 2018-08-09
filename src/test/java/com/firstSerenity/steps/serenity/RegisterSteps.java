package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.RegisterPage;
import com.firstSerenity.utils.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class RegisterSteps extends ScenarioSteps {

    private RegisterPage registerPage;

    @Step
    public void setRegisterFields(String firstName, String lastName, String email, String password)
    {
        registerPage.setFirstNameField(firstName);
        registerPage.setLastNameField(lastName);
        registerPage.setEmailField(email);
        registerPage.setPasswordField(password);
        registerPage.setConfirmationField(password);
    }

    @Step
    public void clickRegister(){registerPage.clickRegister();}

    @Step
    public void checkIfErrorDisplayes(){assert(registerPage.checkIfErrorDisplayed());}

    @Step
    public void checkIfAccountCreated(){assert(getDriver().getCurrentUrl().equals(Constants.BASE_URL));}

    @StepGroup
    public void registerWithInvalidInputData(String firstName, String lastName, String email, String password)
    {
        registerPage.open();
        setRegisterFields(firstName,lastName,email,password);
        clickRegister();
        checkIfErrorDisplayes();
    }

    @StepGroup
    public void registerValid(String firstName, String lastName, String email, String password)
    {
        registerPage.open();
        setRegisterFields(firstName,lastName,email,password);
        clickRegister();
        checkIfAccountCreated();
    }
}
