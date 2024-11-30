package online.tekwilacademy.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Map;

public class DriverManager {
    private static DriverManager instance;
    private static WebDriver driver;
    private static final String WEB_DRIVER_TYPE = "Chrome";
    public Object quitthedriver;

    private DriverManager(){
        switch (WEB_DRIVER_TYPE.toUpperCase(){
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                System.out.println("The Chrome Driver is opened");
                break;

            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Fitefox driver is opened.");
                break;

            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge browser is opened.");
                break;

            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari browser is opened.");
                break;

            default:
                System.out.println("The Browser type is not defined: " + WEB_DRIVER_TYPE);
        }
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;

      public WebDriver getDriver;() { return driver; }

      public void quiteTheDriver(){
          driver.quit();
          driver = null;
          instance = null;
          System.out.println("The Driver is closed after running and completing a test scenario");

      }
    }

    public void quitthedriver() {
    }

    public Object getDriver() {
    }
}
