package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDockerTests {
//    @BeforeClass
//    public void startDockerGrid() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start .\\src\\batchFiles\\start_dockerGrid.bat");
//        Thread.sleep(15000);
//    }
//    @AfterClass
//    public void stopDockerGrid() throws InterruptedException, IOException {
//        Runtime.getRuntime().exec("cmd /c start .\\src\\batchFiles\\stop_dockerGrid.bat");
//        Thread.sleep(5000);
//    }
    final private String hubUrl = "http://localhost:4444/wd/hub";
    @Test
    public void test1() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        URL url = new URL(hubUrl);
        RemoteWebDriver driver = new RemoteWebDriver(url,chromeOptions);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test2() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        URL url = new URL(hubUrl);
        RemoteWebDriver driver = new RemoteWebDriver(url,chromeOptions);
        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test3() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        URL url = new URL(hubUrl);
        RemoteWebDriver driver = new RemoteWebDriver(url,chromeOptions);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test4() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        URL url = new URL(hubUrl);
        RemoteWebDriver driver = new RemoteWebDriver(url,firefoxOptions);
        driver.get("https://www.myntra.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test5() throws MalformedURLException {
        EdgeOptions edgeOptions = new EdgeOptions();
        URL url = new URL(hubUrl);
        RemoteWebDriver driver = new RemoteWebDriver(url,edgeOptions);
        driver.get("https://www.ajio.com/");
        System.out.println(driver.getTitle());
    }
}
