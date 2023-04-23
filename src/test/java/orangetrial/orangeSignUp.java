package orangetrial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class orangeSignUp {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.get("https://www.orangehrm.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("(//button[@class='btn btn-ohrm btn-contact-sales'][normalize-space()='Book a Free Demo'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='Form_getForm_FullName']")).sendKeys("Deji");
        driver.findElement(By.xpath("//input[@id='Form_getForm_Email']")).sendKeys("interpercelservice@gmail.com");
        driver.findElement(By.xpath("//input[@id='Form_getForm_Contact']")).sendKeys("7777777");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
//        dropdown options and how to select from it
        Select selectObject = new Select(dropdown);
        List<WebElement> availableOptions = selectObject.getOptions();
         for (WebElement option : availableOptions){
             if(option.getText().equalsIgnoreCase("Nigeria"))
                 option.click();
         }
         driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")).click();
    }
}
