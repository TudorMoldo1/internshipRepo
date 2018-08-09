package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/wishlist/")
public class WishlistPage extends PageObject {
    @FindBy(css="tr[id*=\"item\"]")
    List<WebElementFacade> products;


    public boolean isProductPresent(String productName)
    {
        for(int i=0;i<products.size();i++)
        {
            WebElement name=products.get(i).findElement(By.cssSelector("tr>td>h3>a"));
            if(name.getText().contains(productName.toUpperCase()))return true;
        }
        return false;
    }

    public void deleteProductFromWishlist(String productName)
    {
        for(int i=0;i<products.size();i++)
        {
            WebElement name=products.get(i).findElement(By.cssSelector("tr>td>h3>a"));
            WebElement deleteButton=products.get(i).findElement(By.cssSelector("td>a[class*=\"btn-remove\"]"));
            if(name.getText().contains(productName.toUpperCase())){
                deleteButton.click();
                getDriver().switchTo().alert().accept();
            }
        }
    }

    public boolean productNotPresent(String productName)
    {
        for(int i=0;i<products.size();i++)
        {
            WebElement name=products.get(i).findElement(By.cssSelector("tr>td>h3>a"));
            if(name.getText().contains(productName.toUpperCase()))return false;
        }
        return true;
    }
}
