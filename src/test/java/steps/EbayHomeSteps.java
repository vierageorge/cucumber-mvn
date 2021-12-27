package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @When("I search for {string}")
    public void i_search_for_element(String searchTerm) {
        driver.findElement(By.id("gh-ac")).sendKeys(searchTerm);
        driver.findElement(By.id("gh-btn")).click();
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(int expectedMinElementCount) {
        String itemCount = driver.findElement(By.cssSelector("h1>span.BOLD:first-child")).getText().trim();
        String itemCountClean = itemCount.replace(",", "");
        int itemCountInt = Integer.parseInt(itemCountClean);
        Assert.assertTrue(String.format("Less that %s values were present", expectedMinElementCount), itemCountInt > expectedMinElementCount);
    }

    @When("I search for {string} in {string} category")
    public void iSearchForSoapInBabyCategory(String searchTerm, String categoryName) {
        driver.findElement(By.id("gh-ac")).sendKeys(searchTerm);
        List<WebElement> categoryOptions = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        for(WebElement categoryOption : categoryOptions){
            if(categoryOption.getText().trim().equals(categoryName)){
                categoryOption.click();
                break;
            }
        }
        driver.findElement(By.id("gh-btn")).click();
    }
}
