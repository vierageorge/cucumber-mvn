package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHomeElements {

    WebDriver driver;

    @FindBy(id = "gh-as-a")
    public WebElement advancedLink;

    @FindBy(id = "gh-ac")
    public WebElement searchBox;

    @FindBy(id = "gh-btn")
    public WebElement searchButton;

    @FindBy(css = "h1>span.BOLD:first-child")
    public WebElement numOfItems;

    @FindBy(xpath = "//select[@id='gh-cat']/option")
    public List<WebElement> catOptions;

    public EbayHomeElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
