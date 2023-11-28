package tests.day10_actions_faker_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

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

    WebElement chooseFileButonu = driver.findElement(By.id("file-submit"));

//3.Yuklemek istediginiz dosyayi secelim.
//4.Upload butonuna basalim.
//5.“File Uploaded!” textinin goruntulendigini test edelim.


}

}
