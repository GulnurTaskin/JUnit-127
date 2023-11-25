package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.ReusableMethods;

import java.time.Duration;

public class C05_TestNotasyonu {

    // bir class'in icinde birden fazla bagimsiz calisabilen test olur mu?
    // JUnit ile calisirken class'da birden fazla test oldugunda
    // toplu calistirdigimiz zaman hangi sira ile calisacagini..
    // BILEMEYIZ ve KONTROL EDEMEYIZ

    @Test
    public void testOtomasyonuTest() {
        // test methodlari static olmamalidir, her yerden kolayca ulasilabilmesi icin

        // test icin ayarlamalarimizi yapiyoruz..
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu.com adresine gidin

        driver.get("https://testotomasyonu.com");

        // title'in "Test Otomasyon" icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Test Otomasyon testi PASSED");
        } else {
            System.out.println("Test Otomasyon testi FAILED");


            ReusableMethods.bekle(1);
            driver.quit();


        }
    }

    @Test
    public void wisequarterTest() {

        // test icin gerekli ayarlamalar..

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // wisequarter.com adresine gidin

        driver.get("https://www.wisequarter.com");

        // title'in "Wise" icerdigini test edin

        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();

    }



    @Test
    public void googlTest () {

        // test icin gerekli ayarlamalar..

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // google.com adresine gidin

        driver.get("https://www.google.com");

        // url'in "google" icerdigini test edin

        String expectedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Google testi PASSED");
        }else System.out.println("Google testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();


        }



}