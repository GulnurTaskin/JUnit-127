package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C03_DropdownMenu extends TestBase {

    @Test
    public void dropdownTesti(){

    // ● https://testotomasyonu.com/form adresine gidin.

        driver.get("https://testotomasyonu.com/form");

    // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        // ilk olarak kullanacagimiz ddm'i locate edip kaydedelim
        WebElement dogumGunuDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        // ikinci olarak bir select objesi olusturalim
        // parametre olarak locate ettigimiz ddm'yu yazalim
        Select selectGun = new Select(dogumGunuDdm);
        // ucuncu olarak olusturdugumuz select objesi ile istenen islemleri yapin
        selectGun.selectByIndex(5);// 5 numara ddm'de 5.index'te

    // 2. Dogum tarihi ay seçeneğinden visibleText kullanarak Nisan’i secin

        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByVisibleText("Nisan");

    // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

    // 4. Secilen degerleri consolda yazdirin

        // dropdown menude secim yaptiktan sonra
        // yapilan secimi yazdirmak istersek:
        System.out.println("Secilen tarih: "+selectGun.getFirstSelectedOption().getText()+
                           " "+selectAy.getFirstSelectedOption().getText()+
                           " "+selectYil.getFirstSelectedOption().getText());

    // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın

       List<WebElement> ayOpsiyonElementList = selectAy.getOptions();
       System.out.println(ReusableMethods.stringListeDonustur(ayOpsiyonElementList));
       // [Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

    // 6. Ay Dropdown menusunun boyutunun 30 olduğunu test edin

        Assert.assertEquals(30,ayOpsiyonElementList.size());

        // Expected :30
        // Actual   :13
        // burda bir bug var!

        ReusableMethods.bekle(1);

}
}