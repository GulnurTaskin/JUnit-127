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
    public void testOtomasyonuTest() { // test methodlari static olmamalidir

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
            System.out.println("Test Otomasyon testii PASSED");
        } else {
            System.out.println("Test Otomasyon testi FAILED");


            ReusableMethods.bekle(1);
            driver.quit();


        }
    }

    @Test
    public void wisequarterTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // wisequarter.com adresine gidin

        // title'in "Wise" icerdigini test edin


    }



    @Test
    public void googlTest () {

            //

            //


        }



}