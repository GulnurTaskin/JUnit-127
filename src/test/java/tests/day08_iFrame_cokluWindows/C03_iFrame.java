package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C03_iFrame extends TestBase {

    @Test
    public void test01(){
        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //Cookies kabul edin
        // cookies de iframe icinde oldugundan
        // once o iframe'e gecis yapalim
        WebElement cookiesIFrame = driver.findElement(By.xpath("(//iframe)[6]"));
        driver.switchTo().frame(cookiesIFrame);
        driver.findElement(By.id("save")).click();

        //3) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi : " + iFrameList.size()); // Sayfadaki iframe sayisi : 7
        // iframe sayisi bende 7 cikti ama ahmet hocanin yaptiginda 9 tane cikmisti, ulkeden ulkeye degisebiliyor bazen, dikkat!

        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement playIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(playIFrame);

        driver.findElement(By.xpath("//button[@title='Lire']")).click(); // burdaki xpath ahmet hoca'ninkinde 'Play'
        ReusableMethods.bekle(2);
        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent(); // default ile anasayfaya geri donuyoruz

        ReusableMethods.bekle(2);
    }
}