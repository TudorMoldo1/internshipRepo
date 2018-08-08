package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomepageSteps extends ScenarioSteps {
    private HomePage homePage;

    @Step
    public WebElementFacade getCategory(String category)
    {
        return homePage.getCategory(category);
    }

    @Step
    public WebElementFacade getSubcategory(WebElementFacade category,String subcategory)
    {
        return homePage.getSubcategory(category,subcategory);
    }

    @Step
    public WebElement getProduct(String productName)
    {
        return homePage.getProduct(productName);
    }

    @Step
    public void checkCorrectProduct(String productName, WebElement product){assert(homePage.checkCorrectProduct(productName,product));}

    @StepGroup
    public void selectProduct(String categoryName, String subcategoryName, String productName)
    {
        homePage.open();
        WebElementFacade category=getCategory(categoryName);
        Actions action = new Actions(getDriver());
        action.moveToElement((WebElement)category).build().perform();
        waitABit(1000);
        WebElementFacade subcategory=getSubcategory(category,subcategoryName);
        subcategory.waitUntilClickable();
        subcategory.click();
        WebElement product=getProduct(productName);
        checkCorrectProduct(productName,product);
    }
}
