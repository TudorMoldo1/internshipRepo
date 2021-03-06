package com.firstSerenity.tests;

import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.steps.serenity.SaleSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;


public class SaleTest extends BaseTest {

    @Steps
    private SaleSteps saleSteps;

    @Test
    public void testCheckProductExists()
    {
        saleSteps.login("tudor.moldovanu@evozon.com","1234567");
        saleSteps.verifyProductExists("RACER BACK MAXI DRESS");
    }

    @Test
    public void testCheckProductDoesNotExist()
    {
        saleSteps.login("tudor.moldovanu@evozon.com","1234567");
        saleSteps.verifyProductExists("ecfnjwcw");
    }
}
