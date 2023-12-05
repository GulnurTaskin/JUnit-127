package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebelementScreenshot extends TestBase {

    // bir onceki testte tum sayfanin ekran fotosunu aldik
    // ama eger ekranin sadece bir bolumunun fotosunu cekmek istersek
    // asagidaki adimlari yapmamiz lazim..

    @Test
    public void aramaTesti() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // dress icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text")); // webelementi locate ediyoruz

        String unExpectedAramaSonucu = "0 Products Found"; // istenmeyen arama sonucu
        String actualAramaSonucu = aramaSonucElementi.getText(); // aktuel arama sonucu
        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu); // testimizi yapiyoruz

        ReusableMethods.bekle(3); // driver'a az bekle diyoruz

        // arama sonuc yazisinin screenshot'ini kaydedin, 4 adimda yapiyoruz..

          // 1.adim screenshot alacagimiz webelementi locate et ==> yukarda ettik zaten

          // 2.adim scrennshot'i kaydedecegimiz file'i olusturalim

        File istenenWebelementScreenshot = new File("target/screenshots/istenenWebelementScreenshot.jpg");

          // 3.adim webelement uzerinden screenshot'i alip gecici bir dosyaya kaydedin

        File geciciDosya = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

          // 4.adim gecici dosyayi asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,istenenWebelementScreenshot);

        // target icine screenshots class'i olusturduk
        // dosya yolumuzu ona gore sekillendirdik
        // testimizi yapinca 'istenenWebelementScreenshot.jpg' olarak fotomuzu goruyoruz







    }
}
