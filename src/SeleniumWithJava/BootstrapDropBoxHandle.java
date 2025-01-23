import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BootstrapDropBoxHandle {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.interviewbit.com/java-interview-questions/");

        driver.findElement(By.xpath("//div[contains(text(), 'Resources')]")).click();
        Thread.sleep(2000);

        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@id='Resources']//div//div//a"));
        System.out.println("Total number of elements is: " + listOfElements.size());

        for(int i = 0; i < listOfElements.size(); i++){
            System.out.println("The text of the link is: " + listOfElements.get(i).getText());
            if(listOfElements.get(i).getText().equalsIgnoreCase("All Problems")){
                listOfElements.get(i).click();
                break;
            }
        }

        //driver.quit();
    }
}
