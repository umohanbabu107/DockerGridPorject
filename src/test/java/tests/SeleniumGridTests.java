package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumGridTests {
    @Test
    public void test1(){
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test2(){
        URL url = null;
        ChromeOptions chromeOptions = new ChromeOptions();
        try {
            url = new URL("http://localhost:4444");
        }
        catch (Exception exception){
            System.out.println("Url not found");
        }
        RemoteWebDriver driver = new RemoteWebDriver(url,chromeOptions);
        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
    }
}
