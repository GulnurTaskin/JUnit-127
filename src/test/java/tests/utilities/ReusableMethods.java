package tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi){

        // yaptigimiz testten buraya bir list gonderecegiz
        // bu list webelement'lerden olusacak
        // o da bana string'lerden olusan bir list gonderecek
        // bu method bir list dondurecegi icin return type'i List yapiyoruz.
        // <> icine de String yaziyoruz, stringlerden olusacagi icin
        // bu yeni listenin ismini de stringListeDonustur koyduk.
        // peki bu yeni liste nerden beslenecek?
        // WebElement'lerden olusan elementlerListesi'nden..


        List<String> stringlerListesi = new ArrayList<>();
        // bir ArrayList olusturyoruz
        // buraya for each kullanarak eleman ekleyecegiz

        // each elementlerListesinden elementleri tek tek ele alacak
        for (WebElement each : elementlerListesi
        ) {
            stringlerListesi.add(each.getText()); // sonra each'in getirdigi element'in uzerindeki yaziyi bu method'la alacagiz
        }


        // for loop bitince return diyoruz
        // striglerListesi'ni geri dondurmesi icin

        return stringlerListesi;


    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver titleIleSayfaDegistir(WebDriver driver, String hedefSayfaTitle){



       Set<String> tumWhdSeti = driver.getWindowHandles();

       // burda bir for each loop olusturuyoruz,
       // each ile tumWhdSetindeki handle degerlerini ele aliyoruz
       // sonra eger diyoruz, ele aldigimiz her bir eachTitle, hedef sayfa title'a esitse
       // driver'i bu sayfaya return ile donduruyoruz
       for (String each: tumWhdSeti
       ) {
         String eachTitle = driver.switchTo().window(each).getTitle();
         if (eachTitle.equals(hedefSayfaTitle)){
             return driver;
         }

       }
        return driver;
    }

    public static String IlkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {

        Set<String> tumWhdSeti = driver.getWindowHandles();
        tumWhdSeti.remove(ilkSayfaWhd);
        for (String each:tumWhdSeti
        ){
            return each;
        }

            return null; // bu satirin hic calismayacagini biliyoruz ama
                         // bu return'u eklemeyince intellij uyari veriyor
                         // o yuzden..
                         // javanin gonlu olsun diye bu return'u ekliyoruz ;)
    }
}