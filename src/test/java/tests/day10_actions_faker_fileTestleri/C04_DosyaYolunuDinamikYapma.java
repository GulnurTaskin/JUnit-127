package tests.day10_actions_faker_fileTestleri;

import org.junit.Test;

public class C04_DosyaYolunuDinamikYapma {

    @Test
    public void test01() {

        /*
            Java dosya yolunu dinamik hale getirebilmemiz icin
            bize iki temel konuma ulasmak icin hazir method sunmus

            1-  calistigimiz projenin dosya yoluna ulasmak isterseniz
                System.getProperty("user.dir")

            2- bilgisayarin ana dosyayoluna ulasmak isterseniz
               System.getProperty("user.home")

               Eger bir takim halinde calisiyorsak
               projemizdeki bir dosya
               veya downloads'a indirdigimiz bir dosyanin varligini test etmek istiyorsak
               dosya yolunu bu iki kodu kullanarak dinamik hale getirmeliyiz
         */

        System.out.println(System.getProperty("user.dir"));

        // C:\Users\taski\com.team127_JUnit

        /*
         C:\Users\taski\com.team127_JUnit ==> bu kisim herkesin kendi bilgisayarina ozeldir

         C:\Users\taski\com.team127_JUnit\src\test\java\tests\\utilities\TestBase.java

         \src\test\java\tests\\utilities\TestBase.java ==> ayni projede calisan herkeste bu kisim ayni olmak zorundadir

        */

        System.out.println(System.getProperty("user.home"));

        // C:\Users\taski


    }
}
