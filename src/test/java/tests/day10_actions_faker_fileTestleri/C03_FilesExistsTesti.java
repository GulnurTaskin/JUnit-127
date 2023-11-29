package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExistsTesti extends TestBase {
    @Test
    public void dosyaIndirmeTesti(){

        // 1. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.get("https://the-internet.herokuapp.com/download");

        // 2. logo.png dosyasını indirelim

        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        ReusableMethods.bekle(5);

        // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu ="C:\\Users\\taski\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        // testi ilk yaptigimizda logo.png objesi vardi, artik yok o yuzden test failed ile sonuclaniyor.
        // istersek farkli dosyalari indirip bu sekilde bilgisayarimizda olup olmadigini test edebiliriz

    }
}
