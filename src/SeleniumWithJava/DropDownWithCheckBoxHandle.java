import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropDownWithCheckBoxHandle {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();

        List<WebElement> listOfElements = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//li//a//label"));
        System.out.println("The total number of elements: " + listOfElements.size());

        for(int i = 0; i < listOfElements.size(); i++){
            System.out.println("The text of the labels are: " + listOfElements.get(i).getText());
            listOfElements.get(i).click();
//            if(listOfElements.get(i).getText().equalsIgnoreCase("Bootstrap")){
//                listOfElements.get(i).click();
//                break;
//            }
        }


        driver.quit();
    }
}
