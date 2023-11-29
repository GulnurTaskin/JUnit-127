package tests.day10_actions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C01_FacebookKullaniciOlusturma extends TestBase {
    @Test
    public void facebookTesti(){

       // 1- https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com");

        //2- Cookies kabul edin


        driver.findElement(By.xpath("//*[@data-cookiebanner='accept_button']")).click();

        //3- Yeni hesap olustur butonuna basalim

        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement firstnameKutusu = driver.findElement(By.xpath("//*[@name='firstname']"));
                   // driver'in isim kutusunu bulmasi icin html kodlarini yaziyoruz
        Actions actions = new Actions(driver); // driver'a klavye uzerinden islem yaptirmak icin actions olusturuyoruz
        Faker faker = new Faker(); // fake hesaplar olusturmak icin faker class'dan obje olusturuyoruz

        String email =faker.internet().emailAddress(); // email adresini ikinci defa istedigi icin,
                                                       // buraya bi tane olusturup string olarak kaydediyoruz

        actions.click(firstnameKutusu) // oncelikle isim kutusuna click yapiyoruz
                .sendKeys(faker.name().firstName()) // fake bir isim olusturmasini soyluyoruz
                .sendKeys(Keys.TAB) // ilk isim kutusuna isim yazdiktan sonra diger kutulara gecmek icin tab tusuna basiyoruz
                .sendKeys(faker.name().lastName()) // fake bir soyisim
                .sendKeys(Keys.TAB) // tab email'e gecis
                .sendKeys(email) // fake email adresi, yukarda olusturduk
                .sendKeys(Keys.TAB)
                .sendKeys(email) // mail adresini ikinci kez yazmamizi istiyor
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()) // fake sifre
                .sendKeys(Keys.TAB) // tab ile diger kutuya geciyoruz
                .sendKeys(Keys.TAB) // sonraki kutuya veri yazmak icin ikinci defa tab yapmak gerekiyor, manuelde o sekilde
                .sendKeys("20") // bu sayilari kendimiz yaziyoruz
                .sendKeys(Keys.TAB)
                .sendKeys("Mar") // her ay'i secebiliriz, biz mart her dilde ayni kisaltma oldugu icin mar yaptik
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB) // cinsiyet radio butonunu secili yapmak icin
                .sendKeys(Keys.TAB) // ikinci kez tab yapiyoruz yine kadin tusuna geliyor ama secmiyor
                .sendKeys(Keys.ARROW_RIGHT)// erkek butonu var sagda, ona gecince radio butonu secili oluyor
                .sendKeys(Keys.ARROW_LEFT) // kadin butonunu secili yapmak icin sol tusa basiyoruz
                .perform(); // perform yapmadan calismaz, unutma!

        //5- Kaydol tusuna basalim

        driver.findElement(By.name("websubmit")).click();

        ReusableMethods.bekle(1);



    }
}
