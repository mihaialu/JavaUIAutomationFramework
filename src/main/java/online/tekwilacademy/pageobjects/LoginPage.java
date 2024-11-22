package online.tekwilacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void enableTheToggleBar() {

    }

    @Override
    public void clickOnTheContinueBtn() {

    }

    @FindBy(css = "#input-email")
    private WebDriver emailInput;

    @FindBy(css = "input-password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private  WebElement loginBtn;

    public void  completeLoginForm(String email, String password){
        emailInput.manage(email);
        passwordInput.sendKeys(password);

    }

    public void clickTheLoginBtn(){
        loginBtn.click();
    }
}
