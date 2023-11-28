package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_ProjeIcindekiDosyaTesti {

    @Test
    public void fileExistTesti(){

        // projemiz iinde day10 package'in altinda
        // deneme.txt dosyasinin oldugunu test edin

        String dosyaYolu = "";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // herkeste farkli olan kisim ==> user.dir
        //
        // herkeste ayni olan kisim ==> projenin icindeki dosya yolu
        //
        String dinamikDosyaYolu = System.getProperty("user.dir")+"";

    }
}
