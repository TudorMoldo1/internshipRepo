package com.firstSerenity.tests;

import com.firstSerenity.steps.serenity.HomepageSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.steps.serenity.SearchSteps;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test04_Search.csv",separator=Constants.CSV_SEPARATOR)
public class SearchTest extends BaseTest {


    @Steps
    private SearchSteps searchSteps;
    private HomepageSteps homepageSteps;
    private String searchTerm, productName;

    @Test
    public void testSearch()
    {
        searchSteps.login();
        searchSteps.searchTerm("dress");
        searchSteps.verifyIfDisplayed("dress".toUpperCase());
    }

   /* @Test
    public void testInvalidSearch()
    {
        searchSteps.login();
        searchSteps.searchTerm("dwehgdhj");
        searchSteps.verifyIfDisplayed("dwehgdhj".toUpperCase());
    }

    @Test
    public void testSort()
    {
        searchSteps.login();
        searchSteps.searchTerm("dress");
        assert(searchSteps.sort());
    }

    @Test
    @Title("Tets04-Search")
    public void test04_Search()
    {
        searchSteps.searchFromHomepage(searchTerm);
        searchSteps.verifyIfProductFound(productName);
    }
*/

}
