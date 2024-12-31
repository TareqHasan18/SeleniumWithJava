import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.Duration;

public class HtmlUnitDriverConcept {

    public static void main(String[] args) throws InterruptedException {

        //Testing with Headless browser with HtmlUnitDriver
        //WebDriver driver = new HtmlUnitDriver();

        //With WebDriverManger
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.orangehrm.com/");
        System.out.println("The title of the page is: " + driver.getTitle());

        driver.findElement(By.id("Form_submitForm_action_request")).click();
        Thread.sleep(2000);

        System.out.println("The title of the page:" + driver.getTitle());
        Thread.sleep(2000);

        driver.quit();

    }
}
