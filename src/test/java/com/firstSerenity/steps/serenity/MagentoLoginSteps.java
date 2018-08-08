package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.MagentoLoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MagentoLoginSteps extends ScenarioSteps {
    private MagentoLoginPage loginPage;

    @Step
    public void setCredentials(String username, String password)
    {
        loginPage.open();
        loginPage.setUsername(username);loginPage.setPassword(password);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLogin();
    }


    @Step
    public boolean checkLogin()
    {
        return (loginPage.getDriver().getCurrentUrl().contains("qa1.dev.evozon.com/index.php/admin/dashboard"));
    }

}
