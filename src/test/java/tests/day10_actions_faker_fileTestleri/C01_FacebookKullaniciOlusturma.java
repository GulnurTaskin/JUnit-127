package tests.day10_actions_faker_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C01_FacebookKullaniciOlusturma extends TestBase {
    @Test
    public void facebookTesti(){

       // 1- https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com");

        //2- Cookies kabul edin

        WebElement iframeElementi = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.id("u_0_k_QK")).click();

        //3- Yeni hesap olustur butonuna basalim


        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //5- Kaydol tusuna basalim

        //driver.findElement(By.name("websubmit"));

        ReusableMethods.bekle(5);
    }
}
