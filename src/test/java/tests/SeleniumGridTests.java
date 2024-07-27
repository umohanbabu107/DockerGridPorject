package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SeleniumGridTests extends BaseTest {

    @Test
    public void test2(){
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test3(){
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
