package tests.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void sagClickTesti(){

        // 1- https://testotomasyonu.com/click sitesine gidin

        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(1); // bu bekleme suresini sonradan ekledik
                                         // driver sayfaya gittikten sonra islem yapmadan oncesi beklemesi gerekebilir
                                         // yerini bulup senkronize olmasi icin..

        //2- “DGI Drones” uzerinde sag click yapin

        Actions actions = new Actions(driver); // actions class'indan actions elementi olusturduk
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb")); // uzerinde islem yapacagimiz elementin locate ettik
        actions.contextClick(dgiDronesElementi).perform(); // saga tiklama islemini yaptiriyoruz
                                                           // actions yaptigimizda sonuna mutlaka perform eklemeliyiz
                                                           // actions, yapilacak is ya da isler listesini alir,
                                                           // sonuna eklenen perform "hadi yap!" demektir,
                                                           // o yuzden hadi demeden islem yapmaz..

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText(); // alert'e bu sekilde gidiyoruz, yaziyi getText ile aliyoruz

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept(); // driver'a diyoruz: switchTo ile alert'e git, accept ile tamam diyip kapat


    }
}
