package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C04_CokluWindowKullanimi extends TestBase {

    @Test
    public void test01(){

        // biz driver ile yaptigimiz tum islemlerde
        // ayni window'da calistik

        driver.get("https://testotomasyonu.com");
        System.out.println(driver.getWindowHandle()); // EA3267056ED719D3F78D8E382B80EE1B


        ReusableMethods.bekle(2);

        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle()); // EA3267056ED719D3F78D8E382B80EE1B
        ReusableMethods.bekle(2);

        driver.navigate().back();
        System.out.println(driver.getWindowHandle()); // EA3267056ED719D3F78D8E382B80EE1B
        ReusableMethods.bekle(2);

        // yeniden test otomasyonu sayfasindayiz
        // electronics linkini tiklayalim

        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        System.out.println(driver.getWindowHandle()); // EA3267056ED719D3F78D8E382B80EE1B
        ReusableMethods.bekle(2);


        // burdaki butun handle numaralari ayni, cunku hepsi ayni sekmede acildi


    }

}
