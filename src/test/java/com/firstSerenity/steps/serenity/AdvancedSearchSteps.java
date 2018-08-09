package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.AdvancedSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AdvancedSearchSteps extends ScenarioSteps {
    private AdvancedSearchPage advancedSearchPage;

    @Step
    public void openPage(){advancedSearchPage.open();}

    @Step
    public void setSearchFields(String name, String priceFrom, String priceTo, String gender)
    {
        advancedSearchPage.setNameField(name);
        advancedSearchPage.setPriceFromField(priceFrom);
        advancedSearchPage.setPriceToField(priceTo);
        advancedSearchPage.setGenderField(gender);
    }

    @Step
    public void clickSearchButton(){advancedSearchPage.clickSearchButton();}

    @Step
    public void checkSearchResults(String name,String priceFrom, String priceTo){assert(advancedSearchPage.checkSearchResults(name,priceFrom,priceTo));}
}
