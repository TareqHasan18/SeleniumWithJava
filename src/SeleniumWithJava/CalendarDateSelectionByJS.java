import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CalendarDateSelectionByJS {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://jetsetz.com/");

        WebElement date = driver.findElement(By.id("depDate"));
        String dateVal = "09-September-20220";
        Thread.sleep(2000);

        selectDateByJS(driver, date, dateVal);
        Thread.sleep(2000);

        driver.quit();
    }

    public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','" + dateValue + "');" , element);
    }
}
