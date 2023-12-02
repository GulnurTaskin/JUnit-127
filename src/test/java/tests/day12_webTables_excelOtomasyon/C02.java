package tests.day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02 {

    @Test
    public void  excelOtomasyonTesti() throws IOException {



        String dosyaYolu ="src\\test\\java\\tests\\day12_webTables_excelOtomasyon\\ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        /*

         */

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sayfa1 = workbook.getSheet("sayfa1");
        Row ucuncuSatir = sayfa1.getRow(3);
        Cell ikinciData = ucuncuSatir.getCell(2);

        System.out.println(ikinciData); //
        String actualIstenenUlkeAdi = sayfa1.getRow(11).getCell(2).toString();
        String expectedUlkeAdi ="Azerbaycan";

        Assert.assertEquals(expectedUlkeAdi,actualIstenenUlkeAdi);




    }
}
