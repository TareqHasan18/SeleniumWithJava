import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PracticeLesson {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://practice.automationtesting.in/shop/");

//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        driver.findElement(By.id("msdd")).click();
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[1]/a")).click();
//        Thread.sleep(2000);

        //driver.findElement(By.className("select2-selection__arrow")).click();
//        new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class)
//                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("select2-selection__arrow"))))
//                .click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("select2-search__field")).sendKeys("Bangladesh");
//        Thread.sleep(2000);

        //Date of Birth
        //year
        /*WebElement yearbox = driver.findElement(By.id("yearbox"));
        Select forYearBox = new Select(yearbox);
        forYearBox.selectByVisibleText("2000");
        Thread.sleep(2000);

        //month
        WebElement monthbox = driver.findElement(By.xpath("//div[2]/select[1]"));
        Select forMonthBox = new Select(monthbox);
        forMonthBox.selectByVisibleText("July");
        Thread.sleep(2000);

        //Day
        WebElement daybox = driver.findElement(By.id("daybox"));
        Select forDayBox = new Select(daybox);
        forDayBox.selectByVisibleText("20");
        Thread.sleep(2000);

        //Password
        driver.findElement(By.id("firstpassword")).sendKeys("abc123");
        Thread.sleep(2000);

        //Confirm Password
        driver.findElement(By.id("secondpassword")).sendKeys("abc123");
        Thread.sleep(2000);

        //Submit Button
        driver.findElement(By.id("submitbtn")).click();
        Thread.sleep(2000);

        //Refresh button
        //driver.findElement(By.id("Button1")).click();
        //Thread.sleep(5000);

        //WebElement options = driver.findElement(By.id("msdd"));

        //creating object for select class
        //Select select = new Select(options);
        //Thread.sleep(2000);
        //providing value to select
        //select.selectByVisibleText("Arabic");
        //Thread.sleep(2000);

//        driver.findElement(By.linkText("Alert with OK & Cancel")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("CancelTab")).click();
//        Thread.sleep(2000);
//
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();
//        Thread.sleep(2000);*/
        //driver.findElement(By.linkText("Home")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class)
               .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/h3"))))
                .click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        driver.quit();
    }
}
