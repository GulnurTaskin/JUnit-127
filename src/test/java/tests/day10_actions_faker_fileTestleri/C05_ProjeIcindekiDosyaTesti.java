package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_ProjeIcindekiDosyaTesti {

    @Test
    public void fileExistTesti(){

        // projemiz icersinde day10 package'in altinda
        // deneme.txt dosyasinin oldugunu test edin

        String dosyaYolu = "C:\\Users\\taski\\com.team127_JUnit\\src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // herkeste farkli olan kisim ==> user.dir
        //        C:\Users\taski\com.team127_JUnit
        // herkeste ayni olan kisim ==> projenin icindeki dosya yolu
        //        \src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\deneme.txt

        String dinamikDosyaYolu = System.getProperty("user.dir")+"\\src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\deneme.txt";

    }
}
