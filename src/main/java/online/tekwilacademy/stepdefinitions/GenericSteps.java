package online.tekwilacademy.stepdefinitions;

import online.tekwilacademy.managers.ConfigReaderManager;
import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.pageobjects.Page;
import online.tekwilacademy.pageobjects.ScrollManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;

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

    @Given("The {string} endpoint is accessed")
    public void theIsAccesed(String endpoint) {
        String fullLink = ConfigReaderManager.getProperty("baseURL") + endpoint;
        driver.get(fullLink);
        System.out.println("The accessed link is:"+ fullLink);
    }

    @And("a thread sleep of {int} second is executed")
    public void aThreadSleepOfSecondsIsExecuted(int timeToBe) {
        long timeToBeSlept = 1000;
        Thread.sleep(timeToBeSlept*1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    @Then("the following list of error message is displayed:")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String>listOfErrors) throws InterruptedException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Thread.sleep(500);

        Consumer<? super String> errorMessage;
        listOfErrors.forEach(errorMessage -> {
        boolean messageIsDisplayed = driver.findElement(By.xpath(".//*[contains(text(),'"+
                errorMessage + "')]")).isDisplayed();
        Assertions.assertTrue(messageIsDisplayed,"The error message is displayed");


    }

    @When("the {string} from {string} is clicked")
        public void theFromIsClicked;{String clickableElement, String Object pageName;) throws Exception {
            Class classInstance = Class.forName("online.tekwilacademy.pageobjects" + pageName);
            Field webClickableElementField = classInstance.getDeclaredField(clickableElement);
            webClickableElementField.setAccessible(true);
            Object webElement;
            webElement webClickableElement =(WebElement) webClickableElementField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            ScrollManager.scrollToElement(webClickableElement);
            ((WebElement) webClickableElement).click();
        }
        }
}
