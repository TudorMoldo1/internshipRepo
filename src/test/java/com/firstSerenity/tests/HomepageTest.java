package com.firstSerenity.tests;

import com.firstSerenity.steps.serenity.HomepageSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test02_GetProduct.csv",separator=Constants.CSV_SEPARATOR)
public class HomepageTest extends BaseTest {
    @Steps
    private HomepageSteps homepageSteps;
    String categoryName, subcategoryName, productName;

    @Test
    @Title("Test02 - GetProduct")
    public void test02_GetProduct()
    {
        homepageSteps.selectProduct(categoryName,subcategoryName,productName);
    }
}
