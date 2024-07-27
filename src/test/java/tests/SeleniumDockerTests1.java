package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumDockerTests1 extends BaseTest {

    @Test
    public void test3() {
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test4() {
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test5(){
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test6(){
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test7(){
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ajio.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
