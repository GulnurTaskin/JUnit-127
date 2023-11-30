package tests.Practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class P04 extends TestBase {

    // 1-https://www.automationexercise.com/ adresine gidin
    // 2-Sign-up  butonuna basınız
    // 3-Üye Kayıt sayfasında "New User Signup!" yazısının göründüğünü doğrulayı
    // 4-üye kaydı işlemini başlatın
    // 5-Üye kayit formunu doldurun
    // 6-Üye kaydinin yapildiği mesajının göründğünü doğrulayın

    @Test
    public void aeSignup(){


        // 1-https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        // 2-Sign-up  butonuna basınız

        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // 3-Üye Kayıt sayfasında "New User Signup!" yazısının göründüğünü doğrulayın

        String expectedIcerik="New User Signup!";
        String actualIcerik=driver.findElement(By.xpath("(//h2)[3]")).getText();
        assertEquals(expectedIcerik,actualIcerik);

        // 4-üye kaydı işlemini başlatın

        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastname=faker.name().lastName();
        String email=faker.internet().emailAddress();
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys(firstName+" "+lastname);
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys(email);
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        // 5-Üye kayit formunu doldurun

        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        String pass=faker.internet().password();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
        WebElement days= driver.findElement(By.xpath("//*[@id='days']"));
        Select select=new Select(days);
        select.selectByValue("5");

        WebElement months=driver.findElement(By.xpath("//*[@id='months']"));
        Select selectMonths=new Select(months);
        selectMonths.selectByValue("1");
        WebElement years=driver.findElement(By.xpath("//*[@id='years']"));
        Select selectYears=new Select(years);
        selectYears.selectByValue("1977");

        WebElement newsletterKutusu = driver.findElement(By.id("newsletter"));
        newsletterKutusu.click();

        // driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        driver.findElement(By.id("first_name")).sendKeys(firstName);
        driver.findElement(By.id("last_name")).sendKeys(lastname);
        String address=faker.address().streetAddress();
        driver.findElement(By.id("address1")).sendKeys(address);

        WebElement country= driver.findElement(By.id("country"));
        Select selectCountry=new Select(country);
        selectCountry.selectByValue("Canada");

        String state=faker.address().state();
        driver.findElement(By.id("state")).sendKeys(state);
        String city=faker.address().city();
        driver.findElement(By.id("city")).sendKeys(city);
        String zipCode=faker.address().zipCode();
        driver.findElement(By.id("zipcode")).sendKeys(zipCode);
        String phoneNumber=faker.phoneNumber().phoneNumber();

        ReusableMethods.bekle(2);
        driver.findElement(By.id("mobile_number")).sendKeys(phoneNumber+ Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();


        driver.findElement(By.xpath("//*[@data-qa='account-created']")).isDisplayed(); //elementin görünmesine bakarak

        String expectedResult="ACCOUNT CREATED!";
        String actualResult=driver.findElement(By.xpath("//*[@data-qa='account-created']")).getText();
        assertEquals(expectedResult,actualResult); //beklediğimiz ile oluşanın aynı olup olmadığına bakar

    }
}




