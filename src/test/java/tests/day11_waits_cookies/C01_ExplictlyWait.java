package tests.day11_waits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplictlyWait {

    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.


    @Test
    public void implicitlyWaitTesti(){

        // testbase'i extends yapmiyoruz burda,
        // o yuzden her test icin gerekli ayarlamayi yapiyoruz basta
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.

        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        // 6. Add buttonuna basin

        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        // 7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackYaziElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsBackYaziElementi.isDisplayed());

        driver.quit();

    }

    @Test
    public void explicitlyWaitTesti(){

        // testbase'i extends yapmiyoruz burda,
        // o yuzden her test icin gerekli ayarlamayi yapiyoruz basta
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                   // burda iki bekletme seklinin farkini anlamak icin digerini kapatiyoruz

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.

        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

            /*

            Eger kullanmak istedigimiz element locate edilebilir durumda ise
            once locate edip
            sonra istenen condition icin bekleyebiliriz
            Ama bu soruda oldugu gibi
            locate ve bekleme kisir dongu olusturuyorsa
            locate ve bekleme islemi birlikte yapilabilir

                    // 1- bir wait objesi olusturalim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                    // 2- bekleyecegimiz webelement'i locate edin (yani its gone elementi)
        WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));
                    // 3- wait objesini kullanarak istediginiz webelement uzerinde islem yapin
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));

             */
                   // 1- bir wait objesi olusturalim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                   // 2- bekleme icin olusturdugumuz wait objesini  kullanarak
                   //    beklenecek webElementin locate'ini ve beklemeyi birlikte yapariz

        WebElement itsGoneYaziElementi = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        // 6. Add buttonuna basin

        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        // 7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackYaziElementi = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));



        driver.quit();

    }

}
