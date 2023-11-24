package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.ReusableMethods;

import java.time.Duration;

import static java.lang.Integer.parseInt;

public class C04_GoogleAramaTesti {
    public static void main(String[] args) {

        // 1- test icin gerekli ayarlamalari yapin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.google.com/ adresine gidin

        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin

        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        // bazi sitelerde cookies'lerden kurtulduktan sonra normal siteye gecmek icin
        // bir sure beklemek gerekebilir, bekleme suresi eklemeliyiz o zaman

        // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedTitleIcerik = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");

        }

        // 5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // 6- Bulunan sonuc sayisini yazdirin

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucYazisiStr = sonucYaziElementi.getText();
        System.out.println("Bulunan sonuc yazisi: " +sonucYazisiStr);

        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
             // Environ 144000000 résultats (0,30 secondes)

        String[] sonucYazisiArr = sonucYazisiStr.split("");
        String sonucSayisiStr = sonucYazisiArr[1]; //

        // sonucSayisiStr = sonucSayisiStr.replace(".","");

        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D",""); //

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        if (sonucSayisiInt > 10000000){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Arama sonuc sayisi testi FAILED");
        }

        // 8- Sayfayi kapatin

ReusableMethods.bekle(1);
driver.quit();

    }
}
