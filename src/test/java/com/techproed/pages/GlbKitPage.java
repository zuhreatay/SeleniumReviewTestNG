package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbKitPage {

    public GlbKitPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy ( partialLinkText = "Yaldizli Cay bardagisdafas")
    public WebElement produkLinki;
    @FindBy ( xpath = "//h4[@class='pro_new_head']")
    public WebElement header;
    @FindBy ( xpath = "//span[@class='maincolor font24 bold fix-md-set']")
    public WebElement price;
    @FindBy (xpath = "//div[@class='col-md-12']/p")
    public WebElement description;

}
