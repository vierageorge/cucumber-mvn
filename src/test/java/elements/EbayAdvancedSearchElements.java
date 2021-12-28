package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearchElements {

    WebDriver driver;

    @FindBy(id = "gh-la")
    public WebElement ebayLogo;

    @FindBy(id = "_nkw")
    public WebElement searchString;

    @FindBy(id = "_ex_kw")
    public WebElement excludeString;

    @FindBy(xpath = "//input[@name='_udlo']")
    public WebElement minPrice;

    @FindBy(xpath = "//input[@name='_udhi']")
    public WebElement maxPrice;

    @FindBy(id = "searchBtnLowerLnk")
    public WebElement searchButton;

    public EbayAdvancedSearchElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
