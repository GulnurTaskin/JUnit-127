package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTesti() throws IOException {

        //1) Yeni bir test method olusturalim writeExcelTest()
                    // yukarda olusturduk

        //2) Adimlari takip ederek Sayfa1’deki 1.satira kadar gidelim

        String dosyaYolu = "src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //3) 5.hucreye yeni bir cell olusturalim

        sayfa1.getRow(0).createCell(4); // create, olustur

        //4) Olusturdugumuz hucreye “Nufus” yazdiralim

        sayfa1.getRow(0).getCell(4).setCellValue("Nufus"); // set, ata

        //5) 2.satir nufus kolonuna 1500000 yazdiralim

        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        //6) 10.satir nufus kolonuna 250000 yazdiralim

        sayfa1.getRow(9).createCell(4).setCellValue(250000);

        //7) 15.satir nufus kolonuna 54000 yazdiralim

        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        //8) Dosyayi kaydedelim // dosyayi kaydetmezsek yaptigimiz degisikliler gercek tabloda yer almaz

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //9)Dosyayi kapatalim

        fis.close();
        fos.close();
        workbook.close();

            // stream akis demek, file imput stream deyince veri akisi devam eder
            // o yuzden excel dosyasinda isimizi bitirdikten sonra dosya akisini kapatmaliyiz


    }
}
