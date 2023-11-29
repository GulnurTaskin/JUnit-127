package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C06_CheckBox {

    // a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
    // b. Sirt Agrisi ve Carpinti checkbox’larini secin
    // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkboxTesti(){

        //	a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin

        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiCheckBox.sendKeys(Keys.PAGE_DOWN); // sayfa acildiginda sirtagrisi cehecbax'ii gorunmuyor
        // o yuzden Keys.PAGE_DOWN ile sayfayi asagiya kaydiriyoruz

        sirtAgrisiCheckBox.click();

        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        carpintiYaziElementi.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larinin seçili olduğunu test edin

        Assert.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assert.assertTrue(carpintiCheckBox.isSelected());



        //	d. Seker ve Epilepsi checkbox’larinin seçili olmadigini test edin

        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2")); // locate aliyoruz
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7")); // locate aliyoruz

        Assert.assertFalse(sekerCheckBox.isSelected()); // seker checkbox'inin secilmis olmamasini istiyoruz
        Assert.assertFalse(epilepsiCheckBox.isSelected());

        ReusableMethods.bekle(3);
    }
}