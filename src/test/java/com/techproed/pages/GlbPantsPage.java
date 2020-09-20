package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbPantsPage {

    WebDriver driver;
    public GlbPantsPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy ( xpath = "//p[@class='cat_bg_top']")
    public List<WebElement> headers;

//    @FindBy(xpath="(//p[@class='cat_bg_top'])[1]")
//    public WebElement pants01;
//
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[2]")
//    public WebElement pants02;
//
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[3]")
//    public WebElement pants03;
//
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[4]")
//    public WebElement pants04;
//
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[5]")
//    public WebElement pants05
//            ;
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[6]")
//    public WebElement pants06;
//
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[7]")
//    public WebElement pants07;
//
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[8]")
//    public WebElement pants08;
//
//    @FindBy(xpath="(//p[@class='cat_bg_top'])[9]")
//    public WebElement pants09;



}
