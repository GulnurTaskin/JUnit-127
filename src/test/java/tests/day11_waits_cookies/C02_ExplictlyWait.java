package tests.day11_waits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplictlyWait {
@Test
    public void explicitlyWaitTesti(){

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

    driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    // 4. Textbox’in etkin olmadigini(enabled) dogrulayın

    WebElement textBoxElementi = driver.findElement(By.xpath("//input[@type='text']"));
    Assert.assertFalse(textBoxElementi.isEnabled());

    // 5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

    driver.findElement(By.xpath("//*[text()='Enable']")).click();
         // ve textbox etkin olana kadar beklememiz lazim.. 3 adimda yapiyoruz
         // 1. wait objesi olustur
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
         // 2. mumkunse kullanilacak web elementi locate et
         // biz texbox'in kullanilabilir olmasini bekleyecegiz, textbox'i yukarda locate etmistik
         // 3. wait objesi ile istenen webelement uzerinde expected condition bekle
    wait.until(ExpectedConditions.elementToBeClickable(textBoxElementi));

    // 6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    WebElement itsEnableElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

    // 7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    Assert.assertTrue(itsEnableElementi.isEnabled());

    driver.quit();
}
}
