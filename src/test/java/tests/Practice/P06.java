package tests.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class P06 extends TestBase {

    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim

        WebElement tasinacakEleman = driver.findElement(By.xpath("(//*[@*='draggable'])[1 ]"));
        WebElement hedefAlan = driver.findElement(By.xpath("(//*[@*='droppable'])[1]"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(3);
        actions.dragAndDrop(tasinacakEleman,hedefAlan).perform();

        //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin


        WebElement drppedyazisi = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String expectedText="Dropped!";
        String actualText=drppedyazisi.getText();

        Assert.assertEquals(expectedText,actualText);



        
        
      
    }


}
