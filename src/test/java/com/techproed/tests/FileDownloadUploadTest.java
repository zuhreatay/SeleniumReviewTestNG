package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadUploadTest extends TestBase {


    @Test
    public void dosyaVarmi(){
        // Şuanda bulunduğumuz klasörün dosya yolunu veriyor.(String olarak)
        System.out.println(   System.getProperty("user.dir")   );
        // Kullanıcın ana klasörünün dosya yolunu veriyor. (String olarak)
        System.out.println(   System.getProperty("user.home")   );
        // Java ile belirtilen adreste, aradığımız dosyanın var olup olmadığını
        // aşağıdaki kod ile yapabiliyoruz.

        // Eğer dosya varsa, TRUE  - Eğer dosya yoksa, FALSE
        // C:\Users\atayz\IdeaProjects\SeleniumReviewTestNG\pom.xml
        boolean varMi = Files.exists(Paths.get("C:\\Users\\atayz\\IdeaProjects\\SeleniumReviewTestNG\\pom.xml"));
        Assert.assertTrue(varMi);

    }
    @Test
    public void dosyaUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");

        // "dosya seç (choose file)" webelementini locate ettik.
        WebElement coosFile = driver.findElement(By.id("file-upload"));
        // sendKeys ile upload etmek istediğimiz dosyanın adresini göndermemiz gerekiyor.
        coosFile.sendKeys("C:\\Users\\atayz\\Downloads\\pexels-pixabay-533923.jpg");
        driver.findElement(By.id("file-submit")).click();
    }

    @Test
    public void dosyaIndirme() {
        // websitesinden, indirmek istediğimiz dosyayı indirdikten sonra,
        // bilgisayarımızda indirme klasöründe, o dosyanın var olup olmadığını kontrol
        // ediyoruz. Eğer dosya varsa, indirme işleminde bir problem yok diyebiliriz.
        // Dikkat edilmesi gereken bir husus : Bazen indirme işlemi uzun sürebilir. Bu yüzden
        // indirme işleminden sonra, bir müddet beklemek gerekir. Thread.sleep ile yapabiliriz.
        driver.get("http://the-internet.herokuapp.com/download");

        // indirme işlemi başlıyor
        WebElement logo = driver.findElement(By.linkText("logo.png"));
        logo.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //C:\Users\atayz\Downloads\logo.png
        // DOSYA VARSA - TRUE       DOSYA YOKSA - FALSE
        boolean logoVarMi= Files.exists(Paths.get("C:\\Users\\atayz\\Downloads\\logo.png"));
        Assert.assertTrue(logoVarMi);



    }
    }
