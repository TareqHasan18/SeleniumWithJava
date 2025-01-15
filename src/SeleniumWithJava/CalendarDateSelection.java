import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CalendarDateSelection {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demo.automationtesting.in/Datepicker.html");

        driver.findElement(By.id("datepicker2")).click();

        String date = "31-March-2025";
        String dateArr[] = date.split("-");
        String dayOfTheDate = dateArr[0];
        String monthOfTheDate = dateArr[1];
        String yearOfTheDate = dateArr[2];

        Select month = new Select(driver.findElement(By.xpath("//select[@class='datepick-month-year'][1]")));
        month.selectByVisibleText(monthOfTheDate);

        Select year = new Select(driver.findElement(By.xpath("//select[@class='datepick-month-year'][2]")));
        year.selectByVisibleText(yearOfTheDate);
        Thread.sleep(2000);

        //html/body/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]
        //html/body/div[2]/div/div[2]/div/table/tbody/tr[1]/td[4]
        //html/body/div[2]/div/div[2]/div/table/tbody/tr[1]/td[7]

        String firstPartOfXpath = "/html/body/div[2]/div/div[2]/div/table/tbody/tr[";
        String secondPartOfXpath = "]/td[";

        final int totalDaysOfWeek = 7;

        boolean flag = false;
        String dayVal = null;

        for(int rowNum = 1; rowNum <= 6; rowNum++){

            for(int colNum = 1; colNum <= totalDaysOfWeek; colNum++){

                try {
                    dayVal = driver.findElement(By.xpath(firstPartOfXpath + rowNum + secondPartOfXpath + colNum + "]")).getText();
                }catch (NoSuchElementException e) {
                    System.out.println("Please provide a valid value.");
                    flag = false;
                    break;
                }

                System.out.println(dayVal);
                if(dayVal.equalsIgnoreCase(dayOfTheDate)){
                    driver.findElement(By.xpath(firstPartOfXpath + rowNum + secondPartOfXpath + colNum + "]")).click();
                    System.out.println("The selected date is: " + dayOfTheDate + " " + monthOfTheDate + " " + yearOfTheDate);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        driver.quit();
    }
}
