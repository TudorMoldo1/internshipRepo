package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com")
@NamedUrls(
        {
                @NamedUrl(name = "with_parameter", url = "http://qa1.dev.evozon.com/catalogsearch/result/{1}")
        }
)
public class SearchPage extends PageObject {

    @FindBy(css="#search")
    private WebElementFacade searchBar;

    @FindBy(css=".page-title > h1")
    private WebElementFacade title;

    public void openWithParameter(String searchTerm)
    {
        this.open("with_parameter",withParameters("?q="+searchTerm));
    }

    public void setSearchBar(String searchTerm) {
        searchBar.sendKeys(searchTerm);
        openWithParameter(searchTerm);
    }

    public boolean searchPageDisplayed(String searchTerm)
    {
       // if(getDriver().findElement(By.cssSelector(".note-msg")).isDisplayed())return false;
        //return true;
        //return title.getText().contains(searchTerm);
        try{
            if(getDriver().findElement(By.cssSelector(".note-msg")).isDisplayed())return false;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return true;
        }
        return true;

    }
    public List<WebElement> getProducts()
    {
        List<WebElement> products=getDriver().findElements(By.cssSelector("ul[class*='products-grid']>li"));
        return products;
    }

    public WebElement getProduct(String productName)
    {
        List<WebElement> products=getProducts();
        for(int i=0;i<products.size();i++)
        {
            if(products.get(i).getText().contains(productName))return products.get(i);
        }
        return null;
    }

    public void sortByPrice()
    {
        Select sortBy = new Select(getDriver().findElement(By.cssSelector("select[title*=Sort]")));
        sortBy.selectByVisibleText("Price");

    }

    public boolean checkDescendingPrices()
    {
        List<WebElement> products=getProducts();
        List<Double> prices=new ArrayList<Double>();
        for(int i=0;i<products.size();i++)
        {
            if(products.get(i).findElements(By.cssSelector(".old-price")).size()!=0)
            {
                String s=products.get(i).findElement(By.cssSelector(".special-price")).getText();
                String s1=s.replace("$","");
                prices.add(Double.valueOf(s1));
            }
            else
            {
                String s=products.get(i).findElement(By.cssSelector(".price")).getText();
                String s1=s.replace("$","");
                prices.add(Double.valueOf(s1));
            }
        }
        for(int i=0;i<prices.size()-1;i++)
        {
            if(prices.get(i)>prices.get(i+1))return false;
        }
        return true;
    }

    public boolean productDisplayed(String productName)
    {
        WebElement product=getProduct(productName);
        return product!=null;
    }
}
