import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ExplicitWaitConcept {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.citi.com/");
        System.out.println(driver.getTitle());

//        new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
//                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("register_acc"))))
//                .click();
//        Thread.sleep(2000);
        clickOn(driver, driver.findElement(By.id("register_acc")), 10);
        driver.quit();
    }
    public static void clickOn(WebDriver driver, WebElement locator, long timeout) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
        Thread.sleep(2000);
    }
}
