package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumSayfaScreenshot extends TestBase {
    @Test
    public void aramaTesti() throws IOException, IOException {

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Arama sonucunda urun bulunamadigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String expectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertEquals(expectedAramaSonucu,actualAramaSonucu);

        ReusableMethods.bekle(1); // ss'den once, bi bekle diyoruz

        // tum sayfanin fotografini cekip kaydedin, bunu 4 adimda yapiyoruz..

          // 1.adim tss objesi olustur

        TakesScreenshot tss = (TakesScreenshot) driver; // driver'a fotografci sapkasi takiyoruz :)

          // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim

        File tumSayfaScreenshot = new File("target/screenshots/tumSayfaScreenshot.jpg"); // fotonun adini koyuyoruz

          // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE); // fotoyu cektik, kameranin dosyasinda su an, oyle dusunelim

          // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot); // simdi basta olusturdugumuz dosya yoluna ,
        // yani asil kayit etmek istedigimiz yere fotyu kaydediyoruz..

        ReusableMethods.bekle(5);
    }
}
