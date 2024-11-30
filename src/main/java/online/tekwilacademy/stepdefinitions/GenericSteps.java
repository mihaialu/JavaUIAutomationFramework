package online.tekwilacademy.stepdefinitions;

import online.tekwilacademy.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();


    @Then("the URL contains the following keywords {string}")
    public void  theURLContainsTheFollowingKeywords(String args) throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        Object collectKeyword;
        Object driver;
        boolean containsKeywords = driver.getClass(collectKeyword);
        String s = "The url contains :" + containsKeywords;
        Assertions.assertTrue(containsKeywords), "The url contains :" + containsKeywords;);

    }
}
