package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_DosyaYukleme extends TestBase {

@Test
    public void dosyaYuklemeTesti(){

    /*
    selenium'da webdriver ile islemlerimizi yapariz
    webdriver bizim bilgisayarimizdaki dosyalara ulasamaz ve kullanamaz
    Dosya exist veya dosya yukleme islemlerinde java'dan yararlanip
    dosya yolunu kulllanarak islemler yapabiliriz

    dosya yuklemede ise dosya sec butinuna bastigimizda bilgisayarimizdaki sosya yapisi acilir
    ama bie webdriver ile bilgisayarimizdaki dosya yapisinda islem yapamayacagimiz icin
    chooseFile butonuna sendKeys() ile dosya yolunu yollariz

     */

// 1.https://the-internet.herokuapp.com/upload adresine gidelim

    driver.get("https://the-internet.herokuapp.com/upload");

//2.chooseFile butonuna basalim

    WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

    // testlerimizin butun takim uyelerinde calisabilmesi icin
    // dosya yolunu dinamik yapmaliyiz
    // biz bir onceki test'de downloads'a indirdigimiz
    // logo.png'yi yukleyelim


//3.Yuklemek istediginiz dosyayi secelim.

    String dinamikDosyaYolu = System.getProperty("user.home") +   // herkeste farkli olan kisim
            "/Downloads/logo.png";  // herkeste ortak olan kisim

    chooseFileButonu.sendKeys(dinamikDosyaYolu);

//4.Upload butonuna basalim.

    driver.findElement(By.id("file-submit")).click();

//5.“File Uploaded!” textinin goruntulendigini test edelim.


    WebElement uplodedYaziElementi = driver.findElement(By.tagName("h3"));

    String expectedYazi = "File Uploaded!";
    String actualYazi = uplodedYaziElementi.getText();

    Assert.assertEquals(expectedYazi,actualYazi);

    ReusableMethods.bekle(1);

}

}
