package tests.Practice;

import org.junit.*;

public class P02 {


    @BeforeClass
    public  static void setUp(){
        System.out.println("=================Test İşlmleri Başlatıldı===================");
        System.out.println(" ");
        System.out.println(" ");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=================Test İşlmleri Tamamlandı===================");
    }
        @Before
        public void before () {
            System.out.println("BEFORE");
        }
        @After
        public void after () {
            System.out.println("AFTER");
        }
        @Test
        public void test01 () {
            System.out.println("1 numarali test calistiriliyor");
        }
        @Test
        public void test02 () {
            System.out.println("2 numarali test calistiriliyor");
        }
        @Test
        public void test03 () {
            System.out.println("3 numarali test calistiriliyor");
        }
        @Test
        public void test04 () {
            System.out.println("4 numarali test calistiriliyor");
        }
        @Test
        public void test05 () {
            System.out.println("5 numarali test calistiriliyor");
        }

}