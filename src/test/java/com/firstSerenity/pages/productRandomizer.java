package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@DefaultUrl("http://qa1.dev.evozon.com")
public class productRandomizer extends PageObject {
    @FindBy(css=".nav-primary")
    private WebElementFacade categoryList;


    public WebElementFacade getRandomCategory()
    {
        Random rand=new Random();
        System.out.println(categoryList.getText());
        List<WebElementFacade> categories=categoryList.thenFindAll(By.cssSelector(".level0.parent"));
        int randomNum = rand.nextInt((3 - 0) + 1) + 0;
        return categories.get(randomNum);
    }

    public WebElementFacade getRandomSubcategory(WebElementFacade category)
    {
        List<WebElementFacade> subcategories=category.thenFindAll(By.cssSelector("li[class*=\"level1 nav-\"]"));
        Random rand=new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        return subcategories.get(randomNum);
    }

    public List<WebElement> getProducts()
    {
        List<WebElement> products=getDriver().findElements(By.cssSelector("ul[class*='products-grid']>li"));
        return products;
    }

    public WebElement getRandomProduct()
    {
        List<WebElement> products=getProducts();
        Random r=new Random();
        return products.get(r.nextInt(products.size()));

    }

}
