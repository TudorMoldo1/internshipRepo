package com.firstSerenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/catalog/product_compare/index/")
public class ComparePage extends PageObject {

    @FindBy(css="td>p>button")
    private WebElementFacade addToCartButtonLeft;

    @FindBy(css="td[class*=\"last\"]>p>button")
    private WebElementFacade addToCartButtonRight;

    @FindBy(css="td[class*=\"last\"]>div>span")
    private WebElementFacade priceRight;

    @FindBy(css=".price")
    private WebElementFacade priceLeft;

    public double getLeftPrice()
    {
       String s= priceLeft.getText();
        s = s.replace("$", "");
        double price=Double.valueOf(s);
        return price;
    }

    public double getRightPrice()
    {
        String s= priceRight.getText();
        s = s.replace("$", "");
        double price=Double.valueOf(s);
        return price;
    }

    public void addToCartLeft(){
        addToCartButtonLeft.click();
    }
    public void addToCartRight(){
        addToCartButtonRight.click();
    }


}
