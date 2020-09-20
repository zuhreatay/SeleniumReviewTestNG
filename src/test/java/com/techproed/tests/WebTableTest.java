package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {
//class tan calistirdigimizda fail aliriz
    //her defasinda giris yaptigindan dolayi, testleri ayri ayri calistirmaliyiz

    public void login(){
        driver.get("http://fhctrip-qa.com/admin/HotelroomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }

    @Test
    public void headers(){
        login();
        //sayfadaki basliklar : //thead//th
        List<WebElement> headers =driver.findElements(By.xpath("//thead//th"));
        for(WebElement element : headers){
            System.out.println(element.getText());

        }

    }
    @Test
    public void rows(){
        login();
        //sayfadaki satirlar : //tbody/tr
        List<WebElement> rows =driver.findElements(By.xpath("//tbody/tr"));
        for(WebElement w :rows) {
            System.out.println(w.getText());
        }

        }

        @Test
        public void column(){
            login();
        //5. sutun  ://tbody/tr/td[5]

            List<WebElement> columns =driver.findElements(By.xpath("//tbody/tr/td[5]"));
            for(WebElement w :columns) {
                System.out.println(w.getText());
            }
        }

        @Test
        public void cell(){
            login();
            //tbody/tr[2]/td[5] : 2. satır 5. sütun gibi istediğimiz hücreyi yazdırma.
            WebElement cell = driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
            System.out.println(cell.getText());
        }

}
