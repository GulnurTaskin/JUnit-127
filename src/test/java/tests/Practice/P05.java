package tests.Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class P05 extends TestBase {

    // 1- https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2- "An IFrame containing…." textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    // 3- iframe'e gecis yapin
    // 4- Text Box'a "Merhaba Dunya!" yazin.
    // 5- TextBox'in altinda bulunan "Elemental Selenium" link textinin gorunur oldugunu dogrulayin
    //      ve  konsolda yazdirin.

    @Test   // Bir metod olusturun: iframeTest

    public void iFrameTesti() throws InterruptedException {

        // 1- https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2- "An IFrame containing…." textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

        WebElement yaziElementi = driver.findElement(By.xpath("(//h3)[1]"));
        if (yaziElementi.isDisplayed()) {
            System.out.println("Yazi Testi PASSED");
            System.out.println(yaziElementi.getText());
        } else {
            System.out.println("Yazi Testi FAILED");
        }

        // 3- iframe'e gecis yapin

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        // 4- Text Box'a "Merhaba Dunya!" yazin.

        WebElement textArea = driver.findElement(By.id("tinymce"));
        textArea.clear();
        textArea.sendKeys("Merhaba Dünya");
        Thread.sleep(3000);

        driver.switchTo().defaultContent(); // iframe'den cikiyoruz bu sekilde

        //  5- TextBox'in altinda bulunan "Elemental Selenium" link textinin gorunur oldugunu dogrulayin
        //      ve  konsolda yazdirin.


        WebElement eselenium = driver.findElement(By.xpath("(//*[@target='_blank'])[2]"));

        if (eselenium.isDisplayed()) {
            System.out.println("Link Yazısı Görüntülendi");
            System.out.println(eselenium.getText());
        } else {
            System.out.println("Link Yazısı Görüntülenemedi");

            ReusableMethods.bekle(5);
        }

    }
}
