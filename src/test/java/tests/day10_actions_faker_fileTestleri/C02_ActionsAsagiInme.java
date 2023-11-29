package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C02_ActionsAsagiInme extends TestBase {
    @Test
    public void iFrameTesti(){

        // 1- https://html.com/tags/iframe/ sayfasina gidelim

        driver.get("https://html.com/tags/iframe/");

        // 2- video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // her bilgisayarin ekran cozunurlugu farkli oldugu icin
                                                    // kac defa page.down yapacagimizi kestirmek mumkun degil, deneyerek bulabiliriz

        // 3- videoyu izlemek icin Play tusuna basin

           // play butonu iframe icinde oldugundan, once iframe'e gecis yapalim

        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeElementi);
        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("//button[@title='Lire']")).click(); // locate ederken, fransizca 'Lire', play degil.
                                                                                       // sitelerde ulkeden ulkeye degisen boyle farklilik olabiliyor

        // 4- videoyu calistirdiginizi test edin

        WebElement kontrolElementi = driver.findElement(By.xpath("//*[@*='ytp-play-button ytp-button']"));
        ReusableMethods.bekle(1);
        Assert.assertTrue(kontrolElementi.isDisplayed());

        ReusableMethods.bekle(5);


    }
}
