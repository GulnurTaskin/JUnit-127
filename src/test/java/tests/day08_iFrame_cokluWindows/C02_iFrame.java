package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_iFrame extends TestBase {
    @Test
public void test01(){
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    driver.get("https://the-internet.herokuapp.com/iframe");
    // 2 ) Bir metod olusturun: iframeTest
    // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

    WebElement anIframeYaziElementi = driver.findElement(By.tagName("h3"));

    Assert.assertTrue(anIframeYaziElementi.isEnabled());
    System.out.println(anIframeYaziElementi.getText());

    // - Text Box’a “Merhaba Dunya!” yazin.
        /*

        test box bir iframe'in icinde.
        iframe'in icinde olan olan elementlere ulasabilmek icin
        once iframe'e gecis yapmalisiniz

        iframe'e gecis yapmak icin
        -once iframe'i bir webelement olarak locate edin
        -switchTo ile iframe'e gecin

        iframe'e gecis yapinca driver orda kalir
        yeniden anasayfa ile ilgili bir islem yapmak icin
        driver'i yeniden anasayfaya gecirmeliyiz

         */

    WebElement iframeElementi = driver.findElement(By.tagName("iframe"));
    driver.switchTo().frame(iframeElementi);


          /* WebElement textBoxKutusu = driver.findElement(By.tagName("p"));
             textBoxKutusu.clear();
             textBoxKutusu.sendKeys("Merhaba Dunya!"); ---> bu sekilde iframe'e yazi yazdiramayiz! */



    // - TextBox’in altinda bulunan “Elemental Selenium” linki textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        /*
        iframe'e gecis yapinca driver orda kalir
        yeniden anasayfa ile ilgili bir islem yapmak icin
        driver'i yeniden anasayfaya gecirmeliyiz
        asagidaki iki yontemle bir onceki parent frame'e
        ya da en bastaki anasayfaya gecis yapabiliriz

        driver.switchTo().defaultContent(); --> direk anasayfaya gecer
        driver.switchTo().parentFrame(); --> eger ic ice birden fazla iframe varsa bir ustteki iframe'e gecis yapar
         */

        driver.switchTo().parentFrame();

        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());

    ReusableMethods.bekle(3);

    }
}