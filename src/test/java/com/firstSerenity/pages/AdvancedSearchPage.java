package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/catalogsearch/advanced/")
public class AdvancedSearchPage extends PageObject {
    @FindBy(css="#name")
    private WebElementFacade nameField;

    @FindBy(css="#price")
    private WebElementFacade priceFromField;

    @FindBy(css="#price_to")
    private WebElementFacade priceToField;

    @FindBy(css="#gender")
    private WebElementFacade genderField;

    @FindBy(css = "div[class*=\"buttons-set\"]>button[title*=\"Search\"]")
    private WebElementFacade searchButton;

    @FindBy(css = "ul[class*=\"products-grid\"]>li")
    private List<WebElementFacade> products;

    public void setNameField(String name)
    {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setPriceFromField(String priceFrom)
    {
        priceFromField.clear();
        priceFromField.sendKeys(priceFrom);
    }

    public void setPriceToField(String priceTo)
    {
        priceToField.clear();
        priceToField.sendKeys(priceTo);
    }

    public void setGenderField(String gender)
    {
        Select genderSelect=new Select(genderField);
        genderSelect.selectByVisibleText(gender);
    }

    public void clickSearchButton(){searchButton.click();}

    public boolean checkSearchResults(String name, String priceFrom, String priceTo)
    {
        for(int i=0;i<products.size();i++)
        {
            if(!products.get(i).getText().contains(name.toUpperCase()))return false;
            WebElement productPrice;
            if(products.get(i).findElements(By.cssSelector(".old-price")).size()>0) productPrice=products.get(i).findElement(By.cssSelector("p[class*=\"special-price\"]>span[class=\"price\"]"));
            else productPrice= products.get(i).findElement(By.cssSelector(".price"));
            String price=productPrice.getText();
            price=price.replace("$","");
            double pret=Double.valueOf(price);
            if(pret<Double.valueOf(priceFrom)||pret>Double.valueOf(priceTo))return false;
        }
        return true;
    }
}
