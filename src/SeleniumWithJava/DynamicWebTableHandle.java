import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicWebTableHandle {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://money.rediff.com/indices");

        driver.findElement(By.id("showMoreLess")).click();
        Thread.sleep(2000);

        WebElement webTable = driver.findElement(By.id("dataTable"));

        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        int rowsCount = rows.size();

        for(int i = 0; i < rowsCount; i++){
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            int columnsCount = columns.size();

            for(int j = 0; j < columnsCount; j++){
                String cellText = columns.get(j).getText();
                if(cellText.equalsIgnoreCase("BSE LargeCap")){
                    System.out.println("% Change value is: " + columns.get(4).getText() + " Prev close value is: " + columns.get(1).getText());
                }
            }
        }

        driver.quit();
    }
}
