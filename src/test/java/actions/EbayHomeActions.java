package actions;

import elements.EbayHomeElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.CommonSteps;

import java.util.List;

public class EbayHomeActions {

     private WebDriver driver;
     EbayHomeElements ebayHomeElements;

     public EbayHomeActions(CommonSteps commonSteps){
         this.driver = commonSteps.getDriver();
         ebayHomeElements = new EbayHomeElements(driver);
     }

     public void clickAdvancedLink(){
         ebayHomeElements.advancedLink.click();
     }

     public void searchAnItem(String itemName){
         ebayHomeElements.searchBox.sendKeys(itemName);
     }

     public void clickSearchButton(){
         ebayHomeElements.searchButton.click();
     }

     public int getSearchItemsCount(){
         String itemCount = ebayHomeElements.numOfItems.getText().trim();
         String itemCountClean = itemCount.replace(",", "");
         return Integer.parseInt(itemCountClean);
     }

     public void selectCategoryOptions(String categoryName){
         List<WebElement> categoryOptions = ebayHomeElements.catOptions;
         for(WebElement categoryOption : categoryOptions){
             if(categoryOption.getText().trim().equals(categoryName)){
                 categoryOption.click();
                 break;
             }
         }
     }

     public void clickOnLink(String link){
         driver.findElement(By.linkText(link)).click();
     }
}
