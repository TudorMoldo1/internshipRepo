package com.firstSerenity.tests;

import com.firstSerenity.steps.serenity.AdvancedSearchSteps;
import com.firstSerenity.steps.serenity.LoginSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test11_AdvancedSearch.csv",separator=Constants.CSV_SEPARATOR)
public class AdvancedSearchTest extends BaseTest {
    @Steps
    private AdvancedSearchSteps advancedSearchSteps;
    @Steps
    private LoginSteps loginSteps;
    private String name, priceFrom, priceTo, gender;

    @Test
    @Title("test11_AdvancedSearchByNamePriceGender")
    public void test11_AdvancedSearchByNamePriceGender()
    {
        loginSteps.openPage();
        loginSteps.setCredentials("tudor.moldovanu@evozon.com","1234567");
        loginSteps.clickLogin();
        advancedSearchSteps.openPage();
        advancedSearchSteps.setSearchFields(name,priceFrom,priceTo,gender);
        advancedSearchSteps.clickSearchButton();
        advancedSearchSteps.checkSearchResults(name,priceFrom,priceTo);
    }
}
