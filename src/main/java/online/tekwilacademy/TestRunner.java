package online.tekwilacademy;

import online.tekwilacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Map;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = (WebDriver) (WebDriver) DriverManager.getInstance().getDriver();
        driver.get("https://www.google.ru/?hl=ru");

        String theNameOfTheFirstTab = driver.getWindowHandles();

        //Open a new window and navigate to the DIEZ page
        WebDriver driver1 = driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://diez.md/");
        long millis;
        Thread.sleep(millis:2000);
        // Close the current tab
        driver.close();

        WebDriver window = driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.stiri.md/");
        Thread.sleep(millis:2000);
        driver.quit();

    }
}