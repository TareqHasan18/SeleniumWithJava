import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkHandle {

    public static void main(String[] args) throws MalformedURLException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.citi.com/");

        //1 get the list of all the links and images
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        listOfLinks.addAll(driver.findElements(By.tagName("img")));

        System.out.println("The total number of links and images are: " + listOfLinks.size());

        //2. iterate links list to exclude all the links/images doesn't have any href attribute
        List<WebElement> activeLinksAndImages = new ArrayList<>();

        for(int i = 0; i < listOfLinks.size(); i++){
            String link = listOfLinks.get(i).getDomProperty("href");
            String textOfLink = listOfLinks.get(i).getText();
            System.out.println("The link is: " + link + "And text is: " + textOfLink);
            System.out.println(listOfLinks.get(i).getDomAttribute("href"));
            if(listOfLinks.get(i).getDomProperty("href") != null && (!listOfLinks.get(i).getDomProperty("href").isEmpty())){
                activeLinksAndImages.add(listOfLinks.get(i));
            }
        }

        System.out.println("Total active links and images are: " + activeLinksAndImages.size());

        //3. check the href url, with http connection url
        //200 OK
        //404 NOT FOUND
        //500 INTERNAL ERROR
        //400 BAD REQUEST
        for(int j = 0; j < activeLinksAndImages.size(); j++){
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinksAndImages.get(j).getDomProperty("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage(); //which will return OK
            connection.disconnect();
            System.out.println(activeLinksAndImages.get(j).getDomProperty("href") + "  ------>" + response);
        }

        driver.quit();


    }
}
