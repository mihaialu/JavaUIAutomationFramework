package online.tekwilacademy;

import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.managers.RandomDataManager;
import online.tekwilacademy.pageobjects.AccountPage;
import online.tekwilacademy.pageobjects.HomePage;
import online.tekwilacademy.pageobjects.LoginPage;
import online.tekwilacademy.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAllTheTest(){
        System.out.println("This methods is run before all the tests from this class");
    }

    @BeforeEach
    public void beforeEachTest(){

        driver = (WebDriver) DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);

    }


    @Test
    @DisplayName("User is redirected to Account page when registering with valid data")
    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {



        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();



        //Actions on the Register page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();


        Thread.sleep(2000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URL of the page contain the Success keyword");
        DriverManager.getInstance().quitthedriver();

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


    @Test
    @DisplayName("The user remain on the Register page when registering without accepting the terms and conditions")
    public void userRemainOnRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {


        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();



        //Actions on the Register page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.clickOnTheContinueBtn();

        Assertions.assertTrue(driver.getCurrentUrl().contains("register") ,"The page URL has the keyword register");

        DriverManager.getInstance().quitthedriver();

    }

    @Test
    @DisplayName("Navigate to Login page from register Page")
    public  void  navigateToLoginPageFromRegisterPage(){
        registerPage.navigateToLoginPage();
        boolean condition;
        Assertions.assertTrue( condition:driver.getCurrentUrl().contains("login"));
    }

    @AfterEach
    public void afterEachTest(){
        DriverManager.getInstance().quitthedriver();
    }

    @AfterAll
    public static void afterAllTheTests(){
        System.out.println("This method is executed after all the tests");

    }
}
