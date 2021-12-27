package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayAdvancedSearchSteps {

    private WebDriver driver;

    public EbayAdvancedSearchSteps(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
    }

    @Given("I am on Ebay Advanced Search Page")
    public void i_am_on_Ebay_Advanced_Search_Page() {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay Logo")
    public void i_click_on_Ebay_Logo() {
        driver.findElement(By.id("gh-la")).click();
    }
    @Then("I am navigated to Ebay Home Page")
    public void i_am_navigated_to_Ebay_Home_Page() {
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Browser didn't navigate to expected URL", expectedUrl, actualUrl);
    }
}
