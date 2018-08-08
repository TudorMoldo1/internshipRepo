package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/sale.html")
public class SalePage extends PageObject {
    @FindBy(css="ul[class*='products-grid']>li")
    private List<WebElementFacade> products;

    public WebElementFacade getProduct(String productName)
    {
        for(int i=0;i<products.size();i++)
        {
            if(products.get(i).getText().contains(productName.toUpperCase()))return products.get(i);
        }
        return null;
    }

    public boolean productExists(String productName)
    {
        return getProduct(productName)!=null;
    }

    public void addToCart(String productName)
    {
        WebElementFacade product=getProduct(productName);
        WebElement addToCartButton=product.findElement(By.cssSelector(".button.btn-cart"));
        addToCartButton.click();
    }
}
