package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.HomePage;
import com.firstSerenity.pages.LoginPage;
import com.firstSerenity.pages.SalePage;
import com.firstSerenity.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchSteps extends ScenarioSteps {
    private LoginPage loginPage;
    private SearchPage searchPage;
    private HomePage homePage;

    @Step
    public void login()
    {
        loginPage.open();
        loginPage.setEmail("tudor.moldovanu@evozon.com");
        loginPage.setPassword("1234567");
        loginPage.clickLogin();
    }

    @StepGroup
    public boolean sort()
    {
        searchPage.sortByPrice();
        return searchPage.checkDescendingPrices();
    }

    @Step
    public void searchTerm(String searchTerm)
    {
        searchPage.setSearchBar(searchTerm);
    }

    @Step
    public void verifyIfDisplayed(String productName)
    {
        assert(searchPage.searchPageDisplayed(productName));
    }

    @Step
    public void verifyIfProductFound(String productName)
    {
        assert(searchPage.productDisplayed(productName));
    }

    @Step
    public void searchFromHomepage(String searchTerm)
    {
        homePage.open();
        homePage.searchForTerm(searchTerm);
    }

    @Step
    public void pressAddToCompare(){searchPage.pressAddToCompare();}

    @Step
    public void clearCompareList()
    {
        searchPage.cleanCompareList();
    }

    @Step
    public void clickAddToWishlistButton(){searchPage.clickAddToWishlistButton();}
}
