package online.tekwilacademy;

import org.junit.runner.RunWith;

@RunWith(online.tekwilacademy.Cucumber.class)
@CucumberOptions(
        features = "src/main/java/online/tekwilacademy/feuters",
        glue = "online.tekwilacademy.stepdefinitions"
        tags = ""
)

public class CucumberTestRunner {
}

}
