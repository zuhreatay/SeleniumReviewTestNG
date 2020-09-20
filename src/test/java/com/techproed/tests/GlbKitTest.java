package com.techproed.tests;

import com.techproed.pages.GlbKitPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class GlbKitTest {

    @Test (groups = "glbtest")
    public  void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_kitchen"));
        GlbKitPage glbKitPage = new GlbKitPage();
        glbKitPage.produkLinki.click();
        String descriptionText = glbKitPage.description.getText();
        String headerText   = glbKitPage.header.getText();
        String priceText    = glbKitPage.price.getText();
        System.out.println(headerText);
        System.out.println(descriptionText);
        System.out.println(priceText);

    }
}
