package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import tests.utilities.TestBase;

public class C04_CokluWindowKullanimi extends TestBase {

    @Test
    public void test01(){

        // biz driver ile yaptigimiz tum islemlerde
        // ayni window'da calistik

        driver.get("https://testotomasyonu.com");
        System.out.println(driver.getWindowHandle());





    }





}
