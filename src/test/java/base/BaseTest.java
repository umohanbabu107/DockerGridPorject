package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties properties;
    protected String hubUrl;


    private void loadConfigurations() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("resources/technicalConfigurations.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties.");
        }
    }

    protected WebDriver initializeDriver() {
        this.loadConfigurations();

        String runningEnvironment = properties.getProperty("env");
        String browser = properties.getProperty("browser");

        if (runningEnvironment.equalsIgnoreCase("remote")) {
            initializeRemoteDriver(browser);
        } else {
            initializeLocalDriver(browser);
        }
        return driver;
    }

    private void initializeLocalDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    private void initializeRemoteDriver(String browser) {
        this.hubUrl = properties.getProperty("hubUrl");
        URL gridUrl;
        try {
            gridUrl = new URL(this.hubUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Malformed Grid URL.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(gridUrl, chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(gridUrl, firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new RemoteWebDriver(gridUrl, edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    public WebDriver getDriver() {
        return driver = initializeDriver();
    }

    // Add more common methods if needed
}
