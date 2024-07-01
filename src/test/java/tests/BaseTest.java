package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utilities.Configurations;

import java.net.URL;

public class BaseTest {
    private final Configurations configurations = new Configurations();
    public static WebDriver driver;
    String browser = "chrome";
    public WebDriver driverSetup() {
        URL url = null;
        String parameter = configurations.getPropertyByKey("env");
        switch (parameter){
            case "local":
                driver = new ChromeDriver();
            case "remote" :
                DesiredCapabilities dc = new DesiredCapabilities();
                try {
                    url = new URL(configurations.getPropertyByKey("hubUrl"));
                }
                catch (Exception exception){

                }
                driver = new RemoteWebDriver(url,dc);
        }
        return driver;
    }
    @BeforeMethod
    public void driverInti(){
        driver = driverSetup();
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
