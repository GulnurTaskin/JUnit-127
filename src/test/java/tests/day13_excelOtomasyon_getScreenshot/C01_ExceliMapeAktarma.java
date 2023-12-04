package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExceliMapeAktarma {
    @Test
    public void readExcelTesti() throws IOException {

        String dosyaYolu = "src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx"; // yolcu
        FileInputStream fis = new FileInputStream(dosyaYolu); // tren
        Workbook workbook = WorkbookFactory.create(fis); // trenin yolcuyu goturup birakacagi gar

        // Ulkeler excel'indeki Turkce ulke isimleri ve
        // Turkce baskent isimlerini bir Map olarak kaydedin
        // Ulke isimleri key, baskent isimleri value olsun

        Map<String,String> ulkelerMap = new TreeMap<>();
        // bu workbok'da bir map objesi olusturuyoruz
        String satirdakiUlkeIsmi; // turkce ulke ismi kutusu
        String satirdakiBaskentIsmi; // turkce baskent ismi kutusu
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum(); // tablodaki toplam satir sayisi

        for (int i = 0; i <=sonSatirIndex ; i++) {
            satirdakiUlkeIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
            satirdakiBaskentIsmi= workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);// ulkeler map'ine key, value seklinde elementleri ekliyoruz
        }

        // Rusya'nin baskentinin Moskova oldugunu test edelim

        String expectedBaskentIsmi= "Moskova";
        String actualBaskentIsmi = ulkelerMap.get("Rusya"); // ulkeler map'i bu sekilde isimize yariyor
        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

        // Listede baskenti San Marino olan bir ulke oldugunu test edelim

        Assert.assertTrue(ulkelerMap.containsValue("San Marino")); // ulkeler map'inin value degerini istiyoruz

        // Listede Filipinler'in oldugunu test edelim

        Assert.assertTrue(ulkelerMap.containsKey("Filipinler")); // ulkeler map'inin key degerini istiyoruz
    }


}
