package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// C04 classindaki testi aynen aldik buraya yapistirdik
// uc ayri @Test notasyonu icindeki testleri birlestirdik
// testlerimiz duzgun calisirken problem yok
// ama birinde bir hata oldugunda butun testin calismasi bozulur
// o yuzden farkli @Test notasyonlari kullanmak raporlamada bizim isimizi kolaylastirir
public class C05_Assertions {

    // https://www.bestbuy.com/ Adresine gidin
    // Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // farkli test method’lari olusturarak asagidaki testleri yapin:
    //          titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //          logoTest => BestBuy logosunun görüntülendigini test edin
    //          FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
    @BeforeClass
    public  static  void setup (){
        // test icin gerekli ayarlamalari BeforeClass'ta yapiyoruz
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //  https://www.bestbuy.com/ Adresine gidin
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){

        driver.quit();

    }

    @Test
    public void urlTesti(){

        //  Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);




        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unexpectedIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedIcerik));



        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[2]"));

        Assert.assertTrue(logoElementi.isDisplayed());


        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaislinkElementi = driver.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(francaislinkElementi.isDisplayed());

    /*
        Bize verilen gorevde
        birden fazla assertion varsa
        tumunu tek test method'unda yapmak
        bize is yuku acisindan daha pratik gelebilir
        AMMA
        bir test method'unda birden faazla assertion oldugunda
        - her bir assertion ayri ayri raporlanmamis olur
        - bir assertion failed oldugunda kod calismasi durur
          kalan assertion'larin sonucunu bilemeyiz
          once hata veren assertion'i duzeltip sonra tekrar calistirmamiz gerekir
     */




    }
}


