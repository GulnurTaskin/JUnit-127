package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C05_KontrolluCokluWindowIleCalisma extends TestBase {

    @Test
    public void kontrolluCokluWindowTesti(){

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin

        String expectedIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        String anasayfaWHD = driver.getWindowHandle();
        // yeni bir tab olarak elctronics linkini acin

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        String electronicsWHD = driver.getWindowHandle();
        // acilan sayfanin electronics sayfasi oldugunu test edin
           // Title'da "Electronics" oldugunu test edelim

        String expectedTitleIcerik = "Electronics";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // yeni bir window'da acilacak sekilde menfashion linkini tiklayin

        driver.switchTo().newWindow(WindowType.TAB).get("https://testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
        String menFashionWHD = driver.getWindowHandle();
        // menfashion sayfasinin acildigini test edin

        expectedTitleIcerik = "Men Fashion";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // ilk actigimiz sayfaya donun
               // eger bir testte acilan window'lar farkli tab veya window'larda aciliyorsa
               // ve testimizde bu sayfalar arasinda gecis isteniyorsa
               // gectigimiz her sayfanin handle degerini aydetmeliyiz

        driver.switchTo().window(anasayfaWHD);

        // test otomasyon anasayfada oldugumuzu test edin
        // url ile test edelim https://testotomasyonu.com/

        String expectedUrl = "https://www.testotomasyonu.com/";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        // tekrar electronics acik olan tab'a gecin

        driver.switchTo().window(electronicsWHD);

        // tekrar men fashion acik olan tab'a gecin

        driver.switchTo().window(menFashionWHD);

        // men fashion sayfasinda oldugunuzu test edin

        expectedTitleIcerik = "Men Fashion";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));


        ReusableMethods.bekle(1);
        driver.quit();



    }


}
