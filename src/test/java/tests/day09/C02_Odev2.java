package tests.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C02_Odev2 extends TestBase {

    // icinde oldugumuz sayfa ve driver'i input olarak alip
    // ikinci sayfa window handle degerini bize donduren
    // bir method kullanalim

    @Test
    public void driverTasimaTesti(){


        //  Kontrolsuz bir tab/window acildiginda
        //  eger yeni acilan tab/window'un title degeri biliniyorsa
        //  driver'i acilan sayfaya geciren bir method olusturun
        //
        // input : driver , Test Otomasyonu - Electronics



        //● https://testotomasyonu.com/addremove/ adresine gidin.

        driver.get("https://testotomasyonu.com/addremove/");
        String ilkSayfaWhd = driver.getWindowHandle();

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.

        WebElement yaziElementi = driver.findElement(By.tagName("h2"));

        String expectedYazi = "Add/Remove Elements";
        String actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.

        driver.findElement(By.linkText("Electronics Products")).click();
              // bu linke tiklayinca electronics sayfasi yeni bir sekmede aciliyor
              // o yuzden driver'i o sekmeye tasimamiz lazim

        // ● Electronics sayfasinin acildigini test edin
              // driver'i tasiyabilmek icin ikinci sayfanin whd'i bulmamiz lazim.
              // reusable methods'da asagidaki methodu olusturduk, buraya cagiriyoruz..
       String ikinciWhd = ReusableMethods.IlkSayfaWhdIleIkinciSayfaWhdBul(driver,ilkSayfaWhd);
       driver.switchTo().window(ikinciWhd);
              // ikinci sayfanin whd'sini bulunca driver'i switchTo ile oraya gonderiyoruz

        // ● Bulunan urun sayisinin 16 olduğunu test edin

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D","");
        // bu bana sting olarak 16'yi verecek, bunu integer'a cevirmeliyim
        int actualSonucSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi = 16;

        Assert.assertEquals(expectedSonucSayisi,actualSonucSayisi);

        //● Ilk actiginiz addremove sayfasina donun

        driver.switchTo().window(ilkSayfaWhd);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(5);
    }
}
