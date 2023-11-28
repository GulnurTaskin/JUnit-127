package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExistsTesti extends TestBase {
    @Test
    public void dosyaIndirmeTesti(){

        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim

        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        ReusableMethods.bekle(5);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu ="C:\\Users\\taski\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
