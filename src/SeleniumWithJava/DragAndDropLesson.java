import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropLesson {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.automationtesting.in/Static.html");

        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("angular")))
                .moveToElement(driver.findElement(By.id("droparea")))
                .release()
                .build()
                .perform();


        Thread.sleep(3000);

        driver.quit();
    }
}
