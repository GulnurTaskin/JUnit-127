package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C05_JsAlerts extends TestBase {
    // 3 test method’u olusturup asagidaki gorevi tamamlayin
    // 1. Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 1.alert’e tiklayin
    // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
    // - OK tusuna basip alert’i kapatin
    // 2.Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 2.alert’e tiklayalim
    // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
    // 3.Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 3.alert’e tiklayalim
    // - Cikan prompt ekranina “Abdullah” yazdiralim
    // - OK tusuna basarak alert’i kapatalim
    // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void jsBasicAlert(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@*='jsAlert()']")).click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertyazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertyazisi,actualAlertYazisi);

        //	-  OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();

    }

    @Test
    public void jsConfirmAlert(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 2.alert'e tiklayalim jsConfirm()
        driver.findElement(By.xpath("//*[@onclick = 'jsConfirm()']")).click();
        //	- Cancel'a basip,

        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedResultYazisi ="You clicked: Cancel";
        String actualResultYazisi = resultYaziElementi.getText();

        Assert.assertEquals(expectedResultYazisi,actualResultYazisi);


    }

    @Test
    public void jsPromptTesti() {

        // 3.Test - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 3.alert'e tiklayalim

        driver.findElement(By.xpath("//*[@onclick = 'jsPrompt()']")).click();
        // - Cikan prompt ekranina "Abdullah" yazdiralim

        driver.switchTo().alert().sendKeys("Abdullah");


        // - OK tusuna basarak alert'i kapatalim

        driver.switchTo().alert().accept();
             // saga tiklayip html alamadigimiz her seferde
             // driver'a bu sekilde is yaptiriyoruz

        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim

        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedResultIcerik = "Abdullah";
        String actualResultYazisi = resultYaziElementi.getText();

        Assert.assertTrue(actualResultYazisi.contains(expectedResultIcerik));

        ReusableMethods.bekle(5);
    }








}
