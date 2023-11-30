package tests.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class P07 extends TestBase {




    @Test
    public void fileUploadTest(){

        // 1- https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        // 2- Bilgisayarımızdaki herhangi bir dosyayı buraya yükleyelim
              // once wqlogo.png dosyasini utilies'e ekledim
              // sonra sitedeki dosya yukleyecegimiz alani locate ediyoruz
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
              // WebElement chooseFile = driver.findElement(By.id("drag-drop-upload"));

              // chooseFile'a gonderecegimiz dosyanin dosya yolunu tanimliyoruz
        String dosyaYolu = "C:\\Users\\taski\\com.team127_JUnit\\src\\test\\java\\utilities\\wqlogo.png.jpg";

              // chooseFile alanin icine dosyaYolunu gonderiyoruz
        chooseFile.sendKeys(dosyaYolu);

        driver.findElement(By.id("file-submit")).click(); // upload tusunun yerini locate ediyoruz

        // 3- dosyanin yuklenip yuklenmedigini test edin

        WebElement fileUploaded = driver.findElement(By.xpath("(//h3)[1]"));
              // file uploaded yazisini locate ediyoruz
              // testimizi yapiyoruz

        Assert.assertTrue("File Uploaded", fileUploaded.isDisplayed());
        ReusableMethods.bekle(5);
    }

}
