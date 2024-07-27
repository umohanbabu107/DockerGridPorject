package tests;


import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {

    @Test
    public void test1() {
        WebDriver driver = initializeDriver();
        this.driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Google");
        driver.quit();
    }
}

