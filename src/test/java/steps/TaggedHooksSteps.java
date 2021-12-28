package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TaggedHooksSteps {

    private WebDriver driver;

    public TaggedHooksSteps(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
    }

    @Before(value = "@setCookies", order = 1)
    public void setCookies(){
        System.out.println("Setting some cookies over here...");
    }

    @After(value = "@Test", order = 0)
    public void afterHook(){
        System.out.println("This is the scenario specific after hook!");
    }

}
