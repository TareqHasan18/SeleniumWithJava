import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VisibilityTestOfElements {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*
        //driver.get("https://accounts.lambdatest.com/login?_gl=1*1sathx4*_gcl_au*MzgyNTQzMzM0LjE3MzUwOTIzMjU.");
        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("athankm77@gmail.com");
        driver.findElement(By.id("password")).sendKeys("");

        boolean toCheckIsDisplayed = driver.findElement(By.id("login-button")).isDisplayed();
        System.out.println(toCheckIsDisplayed);

        boolean toCheckIsEnabled = driver.findElement(By.id("login-button")).isEnabled();
        System.out.println(toCheckIsEnabled);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        boolean toCheckIsSelected = driver.findElement(By.id("login-button")).isSelected();
        System.out.println(toCheckIsSelected);*/

        driver.get("https://demo.automationtesting.in/Register.html");

        driver.findElement(By.id("checkbox1")).click();
        Thread.sleep(2000);
        boolean toCheckIsSelected = driver.findElement(By.id("checkbox1")).isSelected();
        System.out.println(toCheckIsSelected);


        driver.quit();
    }
}
