package online.tekwilacademy;

import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Map;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = (WebDriver) (WebDriver) DriverManager.getInstance().getDriver();
        driver.get("https://www.google.ru/?hl=ru");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        String theNameOfTheFirstTab = driver.getWindowHandles();

        //Open a new window and navigate to the DIEZ page
        WebDriver driver1 = driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());
        long millis;
        Thread.sleep(millis:2000);
        // Close the current tab
        driver.close();

        WebElement myAccountDropDown = driver.findElement(By.xpath("//i[@class= 'fa-solid fa-user']"));
        myAccountDropDown.click();

        WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerLink.click();

        //Print the url of the new page
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());

        WebElement emailInput =driver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(emailData);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String passwordData = RandomDataManager.getRandomPassword();
        System.out.println("Password: " + passwordData);
        passwordInput.sendKeys(passwordData);

        WebElement privacyToggleBar = driver.findElement(By.name("agree"));
        privacyToggleBar.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        Thread.sleep(3000);

        // Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        System.out.println("The driver is on page:" + driver.getCurrentUrl());
        driver.quit();

    }
}