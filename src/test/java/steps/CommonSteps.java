package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        Thread.sleep(1000);
    }

    @Before("@setCookies")
    public void setCookies(){
        System.out.println("Setting some cookies over here...");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
