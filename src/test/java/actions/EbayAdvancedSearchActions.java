package actions;

import elements.EbayAdvancedSearchElements;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class EbayAdvancedSearchActions {

    private WebDriver driver;
    EbayAdvancedSearchElements ebayAdvancedSearchElements;

    public EbayAdvancedSearchActions(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
        ebayAdvancedSearchElements = new EbayAdvancedSearchElements(driver);
    }

    public void clickOnEbayLogo(){
        ebayAdvancedSearchElements.ebayLogo.click();
    }

    public void enterSearchString(String searchTerm){
        ebayAdvancedSearchElements.searchString.sendKeys(searchTerm);
    }

    public void enterExcludedSearchString(String excludedTerms){
        ebayAdvancedSearchElements.excludeString.sendKeys(excludedTerms);
    }

    public void enterMinPrice(String minPrice){
        ebayAdvancedSearchElements.minPrice.sendKeys(minPrice);
    }

    public void enterMaxPrice(String maxPrice){
        ebayAdvancedSearchElements.maxPrice.sendKeys(maxPrice);
    }

    public void clickOnSearchButton(){
        ebayAdvancedSearchElements.searchButton.click();
    }
}
