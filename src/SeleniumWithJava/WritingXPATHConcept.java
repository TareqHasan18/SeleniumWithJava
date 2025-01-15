import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WritingXPATHConcept {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.citi.com/");
        //driver.get("https://www.td.com/us/en/personal-banking");

        //xpath is two types: 1. absolute xpath 2. relative xpath
        //absolute xpath: /html/body/div[1]/div/div/div/div[1]/article/div[2]/div[1]/h1/span
        //Relative xpath: always starts with double forward slash (//)
        //get the html tag of the element
        //then two square brackets, so that means the high level structure is : //html tag[]
        //xpath is recommended when there is no id or name property available for the element

        //Rule 1: //html tag[@property='value']
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("test@test.com");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
//        driver.findElement(By.xpath("//button[@class='cds-button cds-signon-button cds-button-primary cds-button-lg']")).click();
//        Thread.sleep(2000);

        //Rule 2: using contains: //html tag[contains(@property, 'value')]
        //it has the ability to find the element with partial text
        //works better for dynamic value like id=test_123, id=test_456, id=test_789
        //driver.findElement(By.xpath("//a[contains(@class, 'includes')]")).click();
        //Thread.sleep(2000);

        //Rule 3: starts-with - Matches the starting text of the attribute to find the element and
        //works good for long property value
        //also for dynamic id like id=test_123, id=test_456, id=test_789 and this is better than contains
        //driver.findElement(By.xpath("//button[starts-with(@class, 'cds-cta btn-threeup secondaryCta H')]")).click();
        //Thread.sleep(2000);

        //Rule 4: ends-with - opposite of starts-with
        //works better for dynamic locator
        //also for dynamic id like id=123_test, id=456_test, id=789_test
        //structure: //html tag[ends-with(@property, 'ending part of the value')]

        //Rule 5: text() - specially for links
        //matches the text of the links or button, specially for the links
        //example: //a[contains(text(), ' Activate ')] OR //a[text()= ' Activate ']
        //driver.findElement(By.xpath("//a[contains(text(), 'Activate')]")).click();
        //driver.findElement(By.xpath("//a[text()= ' Activate ']")).click();
        //Thread.sleep(2000);

        //Rule 6: using Index number
        //this one works if there is more than one element with same attribute property and value
        //driver.findElement(By.xpath("//li[@class='cmp-link'][1]")).click();
        //Thread.sleep(2000);

        //Rule 7: using 'and' and 'or'
        //when one attribute does not work then use two attributes with 'and' or 'or'
        ////a[@href='#cmp-modal~ccdes2' and @class ='tooltip-bottom-border' ]
        //driver.findElement(By.xpath("//a[@href='#cmp-modal~ccdes2' and @class ='tooltip-bottom-border' ]")).click();
        //driver.findElement(By.xpath("//a[@href='https://www.citi.com/banking/bank-accounts?intc=citihpmenu_overview_bank-accounts' and @class='main-links plusIcon blueCustomerBtns blueAccPadding ng-star-inserted']")).click();
        //driver.findElement(By.id("@id='navOpenAccmainAnchor8")).click();
        //href="https://www.citi.com/banking/bank-accounts?intc=citihpmenu_overview_bank-accounts"
        //Thread.sleep(2000);


        //Rule 8: parent, child and siblings
        ////a[@class='cmp-primary-header__menu-link']//parent::li[@class='cmp-primary-header__menu-item ']
        ////a[text()='Commercial']//parent::li[@class='cmp-link']//preceding-sibling::li[@class='cmp-link']
        //driver.findElement(By.xpath("//a[@class='cmp-primary-header__menu-link']//parent::li[@class='cmp-primary-header__menu-item ']")).click();
        System.out.println(driver.findElement(By.xpath("//p[@class='heading-title ng-star-inserted']")).getText());
        Thread.sleep(2000);


        driver.quit();



    }
}
