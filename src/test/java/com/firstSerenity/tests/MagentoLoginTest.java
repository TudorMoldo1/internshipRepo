package com.firstSerenity.tests;

import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.steps.serenity.MagentoLoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class MagentoLoginTest extends BaseTest {

    @Steps
    MagentoLoginSteps loginSteps;

    @Test
    public void loginWithValidCredentials()
    {
        loginSteps.setCredentials("admin","parola11");
        loginSteps.clickLogin();
        assert(loginSteps.checkLogin());
    }
}
