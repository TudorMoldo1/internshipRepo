package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

    private LoginPage loginPage;

    @Step
    public void openPage(){
        loginPage.open();
    }

    @Step
    public void setCredentials(String email, String pw)
    {
        loginPage.setEmail(email);
        loginPage.setPassword(pw);
    }



    @Step
    public void clickLogin(){loginPage.clickLogin();}

    @Step
    public void checkLogin(String url)
    {
        assert(loginPage.getDriver().getCurrentUrl().equals(url));
    }

    @Step
    public void checkInvalidLogin(String url)
    {
        assert(!loginPage.getDriver().getCurrentUrl().equals(url));
    }

    @StepGroup
    public void login(String user, String pw, String url){
        openPage();
        setCredentials(user, pw);
        clickLogin();
        checkLogin(url);
    }





}
