package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Test1 extends BaseTest {

    @Test
    public void verifyTitle() {
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.google.com/");
        String title = driver1.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Google");
    }

}

