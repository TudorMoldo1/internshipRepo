package com.firstSerenity.steps.serenity;

import com.firstSerenity.pages.ComparePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CompareSteps extends ScenarioSteps {
    private ComparePage comparePage;

    @Step
    public String getSmallerPriceProduct()
    {
        double left=comparePage.getLeftPrice();
        double right=comparePage.getRightPrice();
        if(left<right)return "left";
        return "right";
    }

    @Step
    public void addToCartProductWithSmallerPrice()
    {
        String s=getSmallerPriceProduct();
        if(s.equals("left"))comparePage.addToCartLeft();
        else comparePage.addToCartRight();
    }

    @Step
    public void openPage()
    {
        comparePage.open();
    }
}
