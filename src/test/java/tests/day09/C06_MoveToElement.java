package tests.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_MoveToElement extends TestBase {

   @Test
   public void moveToElementTesti(){

       // 1- https://www.testotomasyonu.com/ adresine gidin

       driver.get("https://www.testotomasyonu.com/");
       ReusableMethods.bekle(1);

       // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin

       WebElement kidsWearElementi = driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));

       Actions actions = new Actions(driver);
       actions.moveToElement(kidsWearElementi).perform();

       ReusableMethods.bekle(1);

       // 3- “Boys” linkine basin

       WebElement boysLinki = driver.findElement(By.linkText("Boys"));
       boysLinki.click();
                        // (//ul[@class='submenu-link'])[2] ahmet hoca bu locate'i kullandi ama bende calismadi, bu locate ile girls linkine tikladi
                        // o yuzden ben de By.linkText("Boys") ile locate yaptim ve calisti2

       // 4- Acilan sayfadaki ilk urunu tiklayin

       driver.findElement(By.xpath("(//div[@class='product-box mb-2 pb-1'])[1]")).click();

       // 5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

       WebElement isimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

       String expectedIsim = "Boys Shirt White Color";
       String actualIsim = isimElementi.getText();


       Assert.assertEquals(expectedIsim,actualIsim);

       ReusableMethods.bekle(1);

    }
}
