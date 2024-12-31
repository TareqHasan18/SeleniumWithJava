import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowPopUpHandle {
    public static void main(String[] args) throws InterruptedException {
        //1. alerts - JavaScript Pop Up - Alert API (accept, dismiss)
        //2. File upload pop up - Browse Button (type - file, sendKeys(path of the file))
        //3. Browser window pop up - Another window pop up (windowHandler API getWindowHandles method)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demo.automationtesting.in/Windows.html");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Open New Seperate Windows")).click();
        driver.findElement(By.id("Seperate")).click();
        Thread.sleep(2000);

        //To collect all the active windows
        Set<String> handler = driver.getWindowHandles();

        //Now need to use Iterator to iterate
        Iterator<String> iterator = handler.iterator();

        String parentWindowId = iterator.next();
        System.out.println("The id of the parent window: " + parentWindowId);

        String childWindowId = iterator.next();
        System.out.println("The id of the child window: " + childWindowId);

        driver.switchTo().window(childWindowId);
        System.out.println("The title of the child window is: " + driver.getTitle());
        Thread.sleep(2000);
        driver.findElement(By.linkText("Register now!")).click();
        Thread.sleep(2000);

        driver.switchTo().window(parentWindowId);
        Thread.sleep(2000);
        System.out.println("The title of the parent window is: " + driver.getTitle());
        Thread.sleep(2000);

        driver.quit();
    }
}
