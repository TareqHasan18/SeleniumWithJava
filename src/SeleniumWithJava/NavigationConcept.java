import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationConcept {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.get("https://www.google.com");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //driver.navigate().to("https://www.citi.com/");
        driver.get("https://demo.automationtesting.in/Register.html");

        driver.findElement(By.linkText("Home")).click();

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
        Thread.sleep(2000);


        driver.quit();
    }
}
