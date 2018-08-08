package com.firstSerenity.tests;

import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.steps.serenity.LoginSteps;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test01_Login.csv",separator=Constants.CSV_SEPARATOR)
public class LoginTest extends BaseTest {


    @Steps
    private LoginSteps loginSteps;
    String user, password;

   /* @Test
    public void testLoginWithValidCredentials()
    {
        loginSteps.openPage();
        loginSteps.setCredentials("tudor.moldovanu@evozon.com","1234567");
        loginSteps.clickLogin();
        loginSteps.checkLogin("http://qa1.dev.evozon.com/customer/account/");
    }

    @Test
    public void testLoginWithInvalidCredentials()
    {
        loginSteps.openPage();
        loginSteps.setCredentials("tudor.moldovanu@evozon.com","123456");
        loginSteps.clickLogin();
        loginSteps.checkInvalidLogin("http://qa1.dev.evozon.com/customer/account/");
    }
*/

    @Test
    @Title("Test01 - Login")
    public void test01_Login()
    {
        loginSteps.openPage();
        loginSteps.setCredentials(user,password);
        loginSteps.clickLogin();
        loginSteps.checkLogin(Constants.BASE_URL+"/customer/account/");
    }
}
