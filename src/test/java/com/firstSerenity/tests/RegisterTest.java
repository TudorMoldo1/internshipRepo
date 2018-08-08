package com.firstSerenity.tests;

import com.firstSerenity.pages.RegisterPage;
import com.firstSerenity.steps.serenity.HomepageSteps;
import com.firstSerenity.steps.serenity.RegisterSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/java/com/firstSerenity/Test03_Register.csv,src/test/java/com/firstSerenity/Test06_Register.csv")
public class RegisterTest extends BaseTest {
    @Steps
    private RegisterSteps registerSteps;
    private String firstName, lastName, email, password;

    @Test
    @Title("Test03_Register")
    @UseTestDataFrom("src/test/java/com/firstSerenity/Test03_Register.csv")
    public void test03_Register()
    {
        registerSteps.register(firstName,lastName,email,password);
    }
    @Test
    @Title("Test06_Register")
    @UseTestDataFrom("src/test/java/com/firstSerenity/Test06_Register.csv")
    public void test06_Register()
    {
        registerSteps.registerValid(firstName,lastName,email,password);
    }
}
