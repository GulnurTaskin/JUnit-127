package tests.day06_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertions {

    @Test
    public void test01(){

        // emeklilik yasi 65 olsun

        // 70 yasi,adaki bir kisinin emekli olabildigini test edin

        int yas = 70;

        Assert.assertTrue(yas>65); // test passed

        int sayi1 = 20;
        int sayi2 = 30;

        // Assert.assertTrue(sayi1>sayi2); // FAILED

        Assert.assertFalse(sayi1>sayi2); // PASSED

        System.out.println("assertion failed olursa bu satir calismaz");

        String actualUrl = "https://testotomasyonu.com/";

        // URL'in testotomasyonu icerdigini test edin

        Assert.assertTrue(actualUrl.contains("testotomasyonu")); // PASSED

        // URL'in wisequarter icermedigini test edin

        Assert.assertFalse(actualUrl.contains("wisequarter")); // PASSED

        // URL'in https://testotomasyonu.com/ oldugunu test edin

        Assert.assertEquals("https://testotomasyonu.com/",actualUrl);




    }
}
