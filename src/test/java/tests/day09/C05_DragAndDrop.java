package tests.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C05_DragAndDrop extends TestBase {

    @Test
    public void dragAndDropTesti(){

        // 1- https://testotomasyonu.com/droppable adresine gidelim

        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement acceptableElementi = driver.findElement(By.id("draggable2"));
        WebElement tasinacakHedefAlan = driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);
           // System.out.println("Tasimadan once: "+ tasinacakHedefAlan.getText());

        ReusableMethods.bekle(1); // bu bekleme'yi eklemedigimizde islem yapamiyor
        actions.dragAndDrop(acceptableElementi,tasinacakHedefAlan).perform(); // perform demezsek calismaz..
        ReusableMethods.bekle(1);

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedAlanYazisi = "Dropped!";
        String actualAlanYazisi = tasinacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazisi,actualAlanYazisi);

        // System.out.println("Tasimadan sonra: "+ tasinacakHedefAlan.getText());
             // normalde testlerde bu sekilde yazdirmali seyler yapmiyoruz
             // sadece sonucu gormek icin yazdirdik burda

        // 4- Sayfayi yenileyin

        driver.navigate().refresh();
        ReusableMethods.bekle(2);// yine kendine gelmesi icin sure ekliyoruz

        // 5- “Not Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement notAcceptableElementi = driver.findElement(By.id("draggable-nonvalid2"));
        tasinacakHedefAlan = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableElementi,tasinacakHedefAlan).perform();

        // 6- “Drop here” yazisinin degismedigini test edin

        expectedAlanYazisi = "Drop Here";
        actualAlanYazisi = tasinacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazisi,actualAlanYazisi);

        ReusableMethods.bekle(1);
    }
}
