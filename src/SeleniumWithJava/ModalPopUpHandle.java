import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class ModalPopUpHandle {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.princetonreview.com/");

        driver.findElement(By.id("signInItem")).click();

        //need to switch to the modal or iframe which has the modal
        driver.switchTo().frame("actionFrame");

        //WebElement myIFrame = driver.findElement(By.id("actionFrame"));
        WebElement headerOfIFrame = driver.findElement(By.id("registrationHeaderByline"));
        System.out.println(headerOfIFrame.getText());
        try{
            Assert.assertEquals(headerOfIFrame.getText(), "Please enter your account information.");
            System.out.println("worked");
        }catch (Exception e){
            System.out.println(e);
        }
        //Assert.assertEquals(headerOfIFrame.getText(), "Please enter your account information.");

        driver.findElement(By.id("Username")).sendKeys("athankm77@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Hellopass123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block' and @value='Sign In']")).click();

        driver.quit();
    }
}
