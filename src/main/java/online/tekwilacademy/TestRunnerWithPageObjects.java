package online.tekwilacademy;

import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.managers.RandomDataManager;
import online.tekwilacademy.pageobjects.AccountPage;
import online.tekwilacademy.pageobjects.HomePage;
import online.tekwilacademy.pageobjects.LoginPage;
import online.tekwilacademy.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunnerWithPageObjects {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = (WebDriver) DriverManager.getInstance().getDriver();

        HomePage homePage = new HomePage(driver);

        homePage.navigateToRegisterPage();

        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();



        //Actions on the Register page
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();


        Thread.sleep(2000);

        //Account related actions
        AccountPage accountPage = new AccountPage(driver);
        accountPage.setLogOutFromTheAccount();

        homePage.navigateToRegisterPage();
        Thread.sleep(2000);

        //Login page related actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickTheLoginBtn();

        Thread.sleep(5000);

        driver.quit();
    }
}
