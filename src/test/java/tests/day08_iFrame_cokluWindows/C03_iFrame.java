package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C03_iFrame extends TestBase {
    @Test
    public void test01(){

        // 1)http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2)Cookies kabul edin
          // cookies de iframe icinde cikti ya laa!!
          // o zaman once o iframe'e gecis yapmak lazim

        WebElement cookiesIFrame = driver.findElement(By.xpath("//*[text()=‘Accept All’]"));


        // 3) sayfadaki iframe sayısını bulunuz.


        // 4) ilk iframe’deki (Youtube) play butonuna tıklayınız.



        // 5) ilk iframe’den çıkıp ana sayfaya dönünüz


        // 6) ikinci iframe’deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız




    }
}
