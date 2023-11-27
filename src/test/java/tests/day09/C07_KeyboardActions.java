package tests.day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C07_KeyboardActions extends TestBase {
    @Test
    public void test01(){

        // 2- https://www.testotomasyonu.com sayfasina gidelim

        driver.get("https://www.testotomasyonu.com");

        //3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu);
        ReusableMethods.bekle(5);

        //4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin


        ReusableMethods.bekle(6);
    }
}
