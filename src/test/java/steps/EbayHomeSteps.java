package steps;

import actions.CommonActions;
import actions.EbayHomeActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class EbayHomeSteps {

    CommonActions commonActions;
    EbayHomeActions ebayHomeActions;

    public EbayHomeSteps( CommonActions commonActions, EbayHomeActions ebayHomeActions){
        this.commonActions = commonActions;
        this.ebayHomeActions = ebayHomeActions;
    }

    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {
        commonActions.goToUrl("https://www.ebay.com/");
    }
    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        ebayHomeActions.clickAdvancedLink();
    }
    @Then("I navigate to Advanced Search Page")
    public void i_navigate_to_advanced_search_page() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = commonActions.getCurrentPageUrl();
        Assert.assertEquals("Browser didn't navigate to expected URL", expectedUrl, actualUrl);
    }

    @When("I search for {string}")
    public void i_search_for_element(String searchTerm) {
        ebayHomeActions.searchAnItem(searchTerm);
        ebayHomeActions.clickSearchButton();
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(int expectedMinElementCount) {
        int itemCountInt = ebayHomeActions.getSearchItemsCount();
        Assert.assertTrue(String.format("Less that %s values were present", expectedMinElementCount), itemCountInt > expectedMinElementCount);
    }

    @When("I search for {string} in {string} category")
    public void iSearchForSoapInBabyCategory(String searchTerm, String categoryName) {
        ebayHomeActions.searchAnItem(searchTerm);
        ebayHomeActions.selectCategoryOptions(categoryName);
        ebayHomeActions.clickSearchButton();
    }
    @When("I click on {string}")
    public void i_click_on(String link) {
        ebayHomeActions.clickOnLink(link);
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void i_validate_that_page_navigates_to_and_title_contains(String expectedUrl, String expectedTitleSubstring) {
        String actualUrl = commonActions.getCurrentPageUrl();
        String actualTitle = commonActions.getCurrentPageTitle();
        Assert.assertEquals("Page navigated to incorrect Url", expectedUrl, actualUrl);
        Assert.assertTrue("Title doesn't contain the expected value", actualTitle.toLowerCase().contains(expectedTitleSubstring.toLowerCase()));
    }
}
