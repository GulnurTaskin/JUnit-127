package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C05_KontrolluCokluWindowIleCalisma extends TestBase {

    @Test
    public void kontrolluCokluWindowTesti(){

        // testotomasyonuu anasayfaya gidin

        driver.get("https://testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin

        String expectedIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // yeni bir tab olarak elctronics linkini acin

        driver.switchTo().newWindow(WindowType.TAB);

        // acilan sayfanin electronics sayfasi oldugunu test edin



        // yeni bir window'da acilacak sekilde menfashion linkini tiklayin

        // menfashion sayfasinin acildigini test edin

        // ilk actigimiz sayfaya donun

        // test otomasyon anasayfada oldugumuzu test edin


        ReusableMethods.bekle(1);
        driver.quit();



    }


}
