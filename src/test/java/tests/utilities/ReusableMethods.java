package tests.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
}