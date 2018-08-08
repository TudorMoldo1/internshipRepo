package com.firstSerenity.utils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public abstract class BaseTest {
    @Managed(uniqueSession = true)
    protected WebDriver driver;

    @Before
    public void maximize()
    {
        driver.manage().window().maximize();
    }

}
