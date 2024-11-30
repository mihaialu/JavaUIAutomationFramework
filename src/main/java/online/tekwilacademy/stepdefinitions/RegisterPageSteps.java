package online.tekwilacademy.stepdefinitions;

import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.managers.RandomDataManager;
import online.tekwilacademy.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = (WebDriver) DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @io.cucumber.java.en.And("^Register Page is accessed from the Home Page buttons$")
    public void registerPageIsAccessedFromTheHomePageButtons() {
        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();



        //Actions on the Register page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);


    }

    @And("The privacy toggle bar is enabled")
    public void thePrivacyToggleBarIsEnabled() {
        RegisterPage registerPage1 = registerPage;
        registerPage1.enableTheToggleBar();

    }

    @When("ThecontinueButtonisClicked")
    public  void theContinueButtonIsClicked() {
        registerPage.clickOnTheContinueBtn();
    }
}
