package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.CartPage;
import com.firstSerenity.pages.LoginPage;
import com.firstSerenity.pages.SalePage;
import com.firstSerenity.pages.productRandomizer;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CartSteps extends ScenarioSteps {
    private CartPage cartPage;
    private SalePage salePage;
    private LoginPage loginPage;
    private productRandomizer productRandomizer;

    @Steps
    private HomepageSteps homepageSteps;

    @Step
    public void login()
    {
        loginPage.open();
        loginPage.setEmail("tudor.moldovanu@evozon.com");
        loginPage.setPassword("1234567");
        loginPage.clickLogin();
    }

    @Step
    public void addToCart(String productName)
    {
        salePage.open();
        salePage.addToCart(productName);
    }

    @Step
    public WebElement getRandomProduct()
    {
        productRandomizer.open();
        WebElementFacade category=productRandomizer.getRandomCategory();
        WebElementFacade subcategory=productRandomizer.getRandomSubcategory(category);
        Actions action = new Actions(getDriver());
        action.moveToElement((WebElement)category).build().perform();
        subcategory.waitUntilClickable();
        subcategory.click();
        WebElement product=productRandomizer.getRandomProduct();
        System.out.println(product.getText());
        return product;
    }

    @Step
    public void addRandomToCart(WebElement product)
    {
        if(product.getText().contains("ADD TO CART")) {
            WebElement addToCartButton = product.findElement(By.cssSelector(".button.btn-cart"));
            addToCartButton.click();
        }
        else{
            WebElement viewDetailsButton=product.findElement(By.cssSelector(".button"));
            viewDetailsButton.click();
            List<WebElement> buttons=getDriver().findElements(By.cssSelector(".swatch-label"));
            buttons.get(0).click();
            buttons.get(buttons.size()-1).click();
            WebElement addToCartButton=getDriver().findElement(By.cssSelector("button.btn-cart:nth-child(1)"));
            addToCartButton.click();
        }
    }

    @StepGroup
    public void addRandomProductToCart()
    {
       WebElement product=getRandomProduct();
        String[] s=product.getText().split("\n");
        String productTitle=s[0];
       addRandomToCart(product);
       checkIfPresent(productTitle);
    }

    @Step
    public void checkIfPresent(String productName)
    {
        cartPage.open();
        assert(cartPage.productIsPresent(productName));
    }

    @Step
    public void checkIfPresent(WebElement product)
    {
        cartPage.open();
        assert(cartPage.checkIfPresent(product));
    }

    @Step
    public void emptyCart()
    {
        cartPage.emptyCart();
        assert(cartPage.checkEmptyCartSuccessful());
    }

    @StepGroup
    public void addProductWithParameters(String categoryName, String subcategoryName, String productName)
    {
        homepageSteps.openPage();
        WebElementFacade category=homepageSteps.getCategory(categoryName);
        Actions action = new Actions(getDriver());
        action.moveToElement((WebElement)category).build().perform();
        waitABit(1000);
        WebElementFacade subcategory=homepageSteps.getSubcategory(category,subcategoryName);
        subcategory.waitUntilClickable();
        subcategory.click();
        WebElement product=homepageSteps.getProduct(productName);
        homepageSteps.checkCorrectProduct(productName,product);
        WebElement addToCartButton=product.findElement(By.cssSelector("button[onClick*=\"setLocation\"]"));
        addToCartButton.click();
        checkIfPresent(productName);
    }
}
