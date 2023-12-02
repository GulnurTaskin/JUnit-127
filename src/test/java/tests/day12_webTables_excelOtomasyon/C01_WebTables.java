package tests.day12_webTables_excelOtomasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01(){

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin

        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin

        List<WebElement> baslikWebelementList = driver.findElements(By.xpath("//div[@role='hdata']"));

              //
        List<String> baslikYazilariList = ReusableMethods.stringListeDonustur(baslikWebelementList);
        System.out.println("Basliklar: "+ baslikYazilariList);

        //  3. 3.sutunun basligini yazdirin

        System.out.println("3.sutun basligi : "+baslikYazilariList.get(2));

        //  4. Tablodaki tum datalari yazdirin


        //  5. Tabloda kac tane cell (data) oldugunu yazdirin

        System.out.println("tablodaki data sayisi :");

        //  6. Tablodaki satir sayisini yazdirin


        //  7. Tablodaki sutun sayisini yazdirin

        System.out.println("tablodaki sutun sayisi: "+baslikYazilariList.size());

        //  8. Tablodaki 3.kolonu yazdirin

        List<WebElement>ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        List<String>ucuncuSutunYaziList = ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList);
        System.out.println("ucuncu sutun: "+ ucuncuSutunYaziList);

        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

           // herhangi bir satirin kategori bilgisi icin locate
           // bir loop ile her bir satiri tek tek inceleyelim
           // kategori degeri yani (2.data) furniture olan satirdaki
           // fiyat degerini yani (3. data) yazdiralim

        String satirdakiKategoriXpath="";
        String satirdakiFiyatXpath="";

        // 10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin






    }

}
