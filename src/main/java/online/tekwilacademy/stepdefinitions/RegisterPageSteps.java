package online.tekwilacademy.stepdefinitions;

import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.managers.RandomDataManager;
import online.tekwilacademy.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

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


    @And("the register form is populated as following:")
    public <userDetailMap> void theRegisterFormIsPopulatedAsFollowing(Map<String>, String> userDetailMap) {
        String firstName = userDetailMap.get("firstName");
        boolean firstNameValue = true;
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = RandomDataManager.getRandomFirstName()

            }


        String lastName = userDetailMap.get("lastName");

        boolean lastNameValue = true;
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")){
            lastNameValue = RandomDataManager.getRandomLastName();
        }

        String email = userDetailMap.get("email");
        boolean emailValue = true;
        if(emailValue !=null && emailValue.toUpperCase().equals("RANDOM")){
            emailValue = RandomDataManager.getRandomEmail();
        }

        String password = userDetailMap.get("password");
        boolean passwordValue;
        if(passwordValue !=null && passwordValue.toUpperCase().equals("RANDOM")){
            passwordValue = RandomDataManager.getRandomPassword();
        }

        registerPage.completeTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);


    }
}
