package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

 WebDriver driver;
    @BeforeClass
    public void setUp(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBoxTest = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alertBoxTest.click();
       String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().sendKeys("Selamlar");
        driver.switchTo().alert().accept(); //accept ok buttonuna tiklamak icin tikladiktan sonra sendKeys calisiyor
       // driver.switchTo().alert().dismiss(); cancel buttonuna basmak icin
    }


}
