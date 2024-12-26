import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeLesson {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.linkText("Alert with OK & Cancel")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("CancelTab")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);

        driver.quit();
    }
}
