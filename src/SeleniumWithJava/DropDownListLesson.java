import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownListLesson {
    public static void main(String[] args) throws InterruptedException {

        //declare a webdriver
        WebDriver driver = new ChromeDriver();

        //to maximize the browser
        driver.manage().window().maximize();

        //To get the url or navigate to the given url
        driver.get("https://www.orangehrm.com/en/book-a-free-demo");

        //get the locator for the dropdown list
        WebElement options = driver.findElement(By.id("Form_getForm_Country"));

        //creating object for select class
        Select select = new Select(options);
        Thread.sleep(2000);
        //providing value to select
//        select.selectByVisibleText("Bangladesh");
//        Thread.sleep(2000);
        List<WebElement> availableOptions = select.getOptions();

        for(WebElement option : availableOptions){
            System.out.println(option.getText());
            if(option.getText().equalsIgnoreCase("Bangladesh")){
                option.click();
            }
            //Thread.sleep(2000);
        }

        driver.quit();
    }
}
