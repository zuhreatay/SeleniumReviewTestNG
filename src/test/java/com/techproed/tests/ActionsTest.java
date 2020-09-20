package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void sagTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        // <span class="context-menu-one btn btn-neutral">right click me</span>
        // linkText : HAYIR (çünkü link değil - "a" tagName'i yok)
        // className: HAYIR (çünkü class değerinin içerisinde BOŞLUK var)
        // tagName, xpath, cssSelector
        // By.xpath("//*[.='right click me']") -> içerdiği yazı "right click me" olan webelement
        WebElement rightClickMe = driver.findElement(By.xpath("//*[.='right click me']"));
        actions.contextClick(rightClickMe).perform();
    }
    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        //<button ondblclick="myFunction()">Double-Click Me To See Alert</button>
        WebElement doubleClick = driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClick).perform();
    }
    @Test
    public void hoverOver(){ // mouse'u bir webelementin üzerine götürme
        driver.get("http://amazon.com");

        // <a href="" class="nav-a nav-a-2" data-nav-ref="nav_ya_signin"
        // data-nav-role="signin" data-ux-jq-mouseenter="true"
        // id="nav-link-accountList" tabindex="0">
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }
    @Test
    public void asagiYukariGitme(){
        driver.get("http://amazon.com");

        //web sayfasının en altına gitmek için
        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //web sayfasında yukarı çıkmak istiyorsak
        //1. YÖNTEM -> PAGE_UP butonu
        actions.sendKeys(Keys.PAGE_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2. YÖNTEM -> ARROW_UP (yukarı yön tuşu)
        actions.sendKeys(Keys.ARROW_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // aşağı gitmek için kullanılıyor
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // alt yön tuşunu kullanarak, aşağı gidebilirsiniz
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    @Test
    public void keyUpKeyDown(){
        // MERHABA nasılsınız
        // shift'e basılı tutarak merhaba               -> MERHABA
        // shift'ten elimizi kaldıracağız nasılsınız    -> nasılsınız
        driver.get("http://google.com");

        WebElement aramaKutusu = driver.findElement(By.name("q"));
        // aramaKutusu.sendKeys("merhaba nasılsınız"); bu sekilde yazildiginda butun harfler kucuk olur
        actions.moveToElement(aramaKutusu)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba ")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasılsınız")
                .perform();



       // actions.keyDown(Keys.SHIFT).sendKeys("merhaba").keyUp(Keys.SHIFT).sendKeys("nasilsin").perform();
    }
    @Test
    public void ikiTusaAyniAndaTiklama(){
        driver.get("http://google.com");

        // ALT + F4 : sayfayı kapatması gerekiyor
        actions.keyDown(Keys.ALT)
                .keyDown(Keys.F4)
                .perform();

        //HOME sayfanin en ustune goturur
        actions.sendKeys(Keys.HOME);
    }
    //Ayni classta bir metod olusturun : keysUpDown()
    //● https://www.google.com/ adresine gidin.
    //● Google text box’a IPHONE (capital) yazdirin
    //○ ( input(giris) => iphone , output => IPHONE)
    //● Text box’ta cift tiklayin(double click).

    @Test
    public void keysUpDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        Thread.sleep(5000);
        actions.moveToElement(googleSearchBox).
                click().
                keyDown(Keys.SHIFT).
                sendKeys("iphone").
                keyUp(Keys.SHIFT).
                perform();



    }
}


