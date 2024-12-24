import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsLesson {
    public static void main(String[] args) throws InterruptedException {

        //declare a webdriver
        WebDriver driver = new ChromeDriver();

        //to maximize the browser
        driver.manage().window().maximize();

        //To get the url or navigate to the given url
        driver.get("https://www.orangehrm.com/");

        //8 locators in selenium
        //locator: id
        //driver.findElement(By.id("Form_submitForm_EmailHomePage")).sendKeys("test@test.com");
        //Thread.sleep(2000);

        //locator: name
        //driver.findElement(By.name("EmailHomePage")).sendKeys("test@test.com");

        //locator: className (not recommended)
        //driver.findElement(By.className("action")).click();

        //locator: linkText
        //driver.findElement(By.linkText("Book a Free Demo")).click();
        //Thread.sleep(2000);

        //locator: partialLinkText (not recommended at all)
//        driver.findElement(By.partialLinkText("Book a Free")).click();
//        Thread.sleep(2000);

        //locator: cssSelector (recommended when id is not available)
//        driver.findElement(By.cssSelector(".btn-tryit-free")).click();
//        Thread.sleep(2000);

        //locator: xpath
        driver.findElement(By.xpath("//*[@id='Form_submitForm_action_request']")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
