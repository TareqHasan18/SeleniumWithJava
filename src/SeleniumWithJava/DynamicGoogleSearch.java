import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicGoogleSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.google.com/");

        driver.findElement(By.id("APjFqb")).sendKeys("java");

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='eIPGRd']"));
        System.out.println("The total number of items in the search box is: " + list.size());

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().contains("java 21")){
                list.get(i).click();
                break;
            }
        }

        driver.quit();
    }
}
