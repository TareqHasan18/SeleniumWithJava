import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.citi.com/");

        Actions actions = new Actions(driver);

//        actions.moveToElement(driver.findElement(By.linkText("Company"))).build().perform();
//        Thread.sleep(2000);
//
//        driver.findElement(By.linkText("Careers")).click();
//        Thread.sleep(2000);

//        actions.moveToElement(driver.findElement(By.linkText("Solutions")))
//                .moveToElement(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/div/div/div/ul/li[1]")))
//                .moveToElement(driver.findElement(By.linkText("HR Administration")))
//                .click()
//                .build()
//                .perform();
//        Thread.sleep(2000);

        //driver.findElement(By.linkText("HR Administration")).click();
        //Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("navcreditCardmainAnchor0")))
                //.moveToElement(driver.findElement(By.xpath("//*[@id=\"dacid_main-nav_header_navigation_1_main-nav-solutions-divisions-amtrust-international\"]")))
                //.click()
                .build()
                .perform();
        driver.findElement(By.id("navViewCrdsView All Credit Cardsundefined0")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
