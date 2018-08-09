package com.firstSerenity.tests;

import com.firstSerenity.steps.serenity.CartSteps;
import com.firstSerenity.steps.serenity.CompareSteps;
import com.firstSerenity.steps.serenity.SearchSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test09_ComparePage.csv",separator=Constants.CSV_SEPARATOR)
public class CompareTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;
    @Steps
    private CompareSteps compareSteps;
    @Steps
    private CartSteps cartSteps;
    private String productName1, productName2;

    @Test
    public void Test09_ComparePageAddToCart()
    {
        searchSteps.login();
        searchSteps.searchFromHomepage(productName1);
        searchSteps.clearCompareList();
        searchSteps.pressAddToCompare();
        searchSteps.searchFromHomepage(productName2);
        searchSteps.pressAddToCompare();
        compareSteps.openPage();
        compareSteps.addToCartProductWithSmallerPrice();
        String s=compareSteps.getSmallerPriceProduct();
        if(s.equals("left")){ cartSteps.checkIfPresent(productName1);}
        else {cartSteps.checkIfPresent(productName2);}
    }
}
