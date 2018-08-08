package com.firstSerenity.pages;

import com.firstSerenity.utils.Constants;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl(Constants.BASE_URL)
public class HomePage extends PageObject {
    @FindBy(css=".nav-primary")
    private WebElementFacade categoryList;

    public WebElementFacade getCategory(String category)
    {
        List<WebElementFacade> categories=categoryList.thenFindAll(By.cssSelector(".level0.parent"));
        for(int i=0;i<categories.size();i++)
        {
            if(categories.get(i).getText().contains(category.toUpperCase()))return categories.get(i);
        }
        return null;
    }

    public WebElementFacade getSubcategory(WebElementFacade category, String subcategory)
    {
        List<WebElementFacade> subcategories=category.thenFindAll(By.cssSelector("li[class*=\"level1 nav-\"]"));

       // System.out.println(subcategories);
        subcategories.get(0).waitUntilClickable();
        for(int i=0;i<subcategories.size();i++)
        {

            System.out.println(subcategories.get(i).getText());
            if(subcategories.get(i).getText().contains(subcategory))return subcategories.get(i);
        }
        return null;
    }

    public WebElement getProduct(String productName)
    {
        List<WebElement> products=getDriver().findElements(By.cssSelector("ul[class*='products-grid']>li"));
        for(int i=0;i<products.size();i++)
        {
            if(products.get(i).findElement(By.cssSelector(".product-name")).getText().contains(productName.toUpperCase()))return products.get(i);
        }
        return null;
    }

    public boolean checkCorrectProduct(String productName, WebElement product){return  product.getText().contains(productName.toUpperCase());}

    public void searchForTerm(String searchTerm)
    {
        WebElement searchBar=getDriver().findElement(By.cssSelector("#search"));
        searchBar.sendKeys(searchTerm);
        WebElement searchButton=getDriver().findElement(By.cssSelector(".button.search-button"));
        searchButton.click();
    }
}
