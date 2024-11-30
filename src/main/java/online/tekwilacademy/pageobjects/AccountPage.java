package online.tekwilacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{
    public AccountPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void enableTheToggleBar() {

    }

    @Override
    public void clickOnTheContinueBtn() {

    }

    @FindBy(xpath = "//a[@class= 'list-group-item'][normalize-space()='Logout']")
    private WebElement logOutBtn;

    public void  setLogOutFromTheAccount(){
        ScrollManager.scrollToElement(logOutBtn);
        logOutBtn.click();
        System.out.println("The user is logged out");
    }
}
