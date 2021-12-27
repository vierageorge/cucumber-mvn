package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayHomeSteps {

    private WebDriver driver;

    public EbayHomeSteps(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
    }

    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {
        driver.get("https://www.ebay.com/");
    }
    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        driver.findElement(By.id("gh-as-a")).click();
    }
    @Then("I navigate to Advanced Search Page")
    public void i_navigate_to_advanced_search_page() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Browser didn't navigate to expected URL", expectedUrl, actualUrl);
    }

    @When("I search for iPhone 11")
    public void iSearchForIPhone() {
        driver.findElement(By.id("gh-ac")).sendKeys("iPhone 11");
        driver.findElement(By.id("gh-btn")).click();
    }

    @Then("I validate at least 1000 search items present")
    public void iValidateAtLeastSearchItemsPresent() {
        String itemCount = driver.findElement(By.cssSelector("h1>span.BOLD:first-child")).getText().trim();
        String itemCountClean = itemCount.replace(",", "");
        int itemCountInt = Integer.parseInt(itemCountClean);
        int expectedMin = 1000;
        Assert.assertTrue(String.format("Less that %s values were present", expectedMin), itemCountInt > expectedMin);
    }
}
