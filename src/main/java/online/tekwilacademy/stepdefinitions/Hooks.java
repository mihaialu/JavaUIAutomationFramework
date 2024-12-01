package online.tekwilacademy.stepdefinitions;

import online.tekwilacademy.managers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Hooks {

    @BeforeAll
    public void executedBeforeEachTest(){
        System.out.println("Test started");
    }

    @Before
    public void executedBeforeEachTest(){
        System.out.println("Test started");
    }

    @After
    public void executeAfterEachTest() {
        System.out.println("The test is completed");
        DriverManager.getInstance().quitthedriver();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("The test execution finished");
    }
}
