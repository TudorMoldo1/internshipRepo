package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/cart/")
    public class CartPage extends PageObject{
    @FindBy(css=".product-cart-info")
    private List<WebElementFacade> products;

    public WebElementFacade getProduct(String productName)
    {
        for(int i=0;i<products.size();i++)
        {
            if(products.get(i).getText().contains(productName))return products.get(i);
        }
        return null;
    }

    public boolean productIsPresent(String productName)
    {
        return getProduct(productName)!=null;
    }

    public void emptyCart()
    {
        WebElement emptyCartButton=getDriver().findElement(By.cssSelector("#empty_cart_button"));
        emptyCartButton.click();
    }

    public boolean checkEmptyCartSuccessful()
    {
        WebElement cartEmptyMessage=getDriver().findElement(By.cssSelector(".page-title"));
        return cartEmptyMessage.getText().contains("Shopping Cart is Empty".toUpperCase());
    }

    public boolean checkIfPresent(WebElement product)
    {
        WebElement grid=getDriver().findElement(By.cssSelector("#shopping-cart-table"));
        String[] s=product.getText().split("\n");
        String productTitle=s[0];
        return grid.getText().contains(productTitle);
    }

}
