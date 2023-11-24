package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class P03 {

    static WebDriver driver;
    WebElement searchbox;
    String filmName;


    // BeforeClass ile driver'i oluşturun ve class icinde static yapin
    // Maximize edin ve 10 sn bekletin
    @BeforeClass
    public static void setUP(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // AfterClass ile kapatin.
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    // http://www.babayigit.net/testdocs adresine gidin
    @Before
    public void before(){
        driver.get("http://www.babayigit.net/testdocs");
        searchbox=driver.findElement(By.xpath("//input[@id='search']"));
    }

    @After
    public void after(){
        System.out.println(filmName+" Sonuç Sayısı: "+driver.findElement(By.xpath("//*[@id='result-stats']")).getText());
        System.out.println("Window Handler: "+driver.getWindowHandle());

    }

    // 1-arama kutusuna "12 Angry Men” yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01(){
        filmName="12 Angry Men";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

    // 2-arama kutusuna "Vizontele” yaz ip, cikan sonuc sayisini yazdirin
    @Test
    public void test02(){
        filmName="Vizontele";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

    // 3-arama kutusuna "Saving Private Ryan” yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03(){
        filmName="Saving private er ryan";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

    // 4-arama kutusuna "3 idiots” yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test04(){
        filmName="3 idiots";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }


}