package online.tekwilacademy.stepdefinitions;

import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = (WebDriver) DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);
    @io.cucumber.java.en.Given("^The Home Page is displayed$")
    public void theHomePageIsDisplayed() {
        driver.get("https://tekwillacademy-opencart.online/");
    }

    @And("Register page is accesed from the Home Page buttons")
    public void registerPageIsAccessedFromTheHomePageButtons() {
        homePage.navigateToRegisterPage();

    }

}
