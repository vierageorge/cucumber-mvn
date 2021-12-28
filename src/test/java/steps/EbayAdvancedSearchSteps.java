package steps;

import actions.CommonActions;
import actions.EbayAdvancedSearchActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EbayAdvancedSearchSteps {

    CommonActions commonActions;
    EbayAdvancedSearchActions ebayAdvancedSearchActions;

    public EbayAdvancedSearchSteps(CommonActions commonActions, EbayAdvancedSearchActions ebayAdvancedSearchActions){
        this.commonActions = commonActions;
        this.ebayAdvancedSearchActions = ebayAdvancedSearchActions;
    }

    @Given("I am on Ebay Advanced Search Page")
    public void i_am_on_Ebay_Advanced_Search_Page() {
        commonActions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay Logo")
    public void i_click_on_Ebay_Logo() {
        ebayAdvancedSearchActions.clickOnEbayLogo();
    }
    @Then("I am navigated to Ebay Home Page")
    public void i_am_navigated_to_Ebay_Home_Page() {
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = commonActions.getCurrentPageUrl();
        Assert.assertEquals("Browser didn't navigate to expected URL", expectedUrl, actualUrl);
    }
    @When("I advanced search an item")
    public void i_advanced_search_an_item(DataTable dataTable) {
        ebayAdvancedSearchActions.enterSearchString(dataTable.cell(1,0));
        ebayAdvancedSearchActions.enterExcludedSearchString(dataTable.cell(1,1));
        ebayAdvancedSearchActions.enterMinPrice(dataTable.cell(1,2));
        ebayAdvancedSearchActions.enterMaxPrice(dataTable.cell(1,3));
        ebayAdvancedSearchActions.clickOnSearchButton();
    }
}
