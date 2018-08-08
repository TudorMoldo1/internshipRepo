package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.LoginPage;
import com.firstSerenity.pages.SalePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SaleSteps extends ScenarioSteps {
    private SalePage salePage;
    private LoginPage loginPage;

    @Step
    public void openPage()
    {
        salePage.open();
    }

    @Step
    public void login(String email, String pw)
    {
        loginPage.open();
        loginPage.setEmail(email);
        loginPage.setPassword(pw);
    }

    @Step
    public void verifyProductExists(String productName)
    {
        salePage.open();
        assert(salePage.productExists(productName));
    }


}
