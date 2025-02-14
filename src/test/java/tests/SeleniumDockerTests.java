package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;



public class SeleniumDockerTests extends BaseTest {
    @Test
    public void test8() {
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test9() {
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test10(){
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test11() {
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void test12() {
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ajio.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
