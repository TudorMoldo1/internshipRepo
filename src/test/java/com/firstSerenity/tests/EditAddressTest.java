package com.firstSerenity.tests;

import com.firstSerenity.steps.serenity.EditAddressSteps;
import com.firstSerenity.utils.BaseTest;
import com.firstSerenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value= Constants.CSV_PATH+"Test08_Address.csv",separator= Constants.CSV_SEPARATOR)
public class EditAddressTest extends BaseTest {

    @Steps
    private EditAddressSteps editAddressSteps;
    private String firstName, lastName, postalCode, telephone, street, country, region, city;

    @Test
    @Title("Test08_Address")
    public void test08_Address()
    {
        editAddressSteps.changeAddress(firstName,lastName,telephone,street,city,postalCode,region,country,"tudor.moldovanu@evozon.com","1234567");
    }
}
