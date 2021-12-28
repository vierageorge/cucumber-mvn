package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    private WebDriver driver;

    @Before(order = 0)
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Global before hook");
    }

    @After(order = 1)
    public void tearDown() throws Exception {
        driver.quit();
        Thread.sleep(1000);
        System.out.println("Global after hook");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
