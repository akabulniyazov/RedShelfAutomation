package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Homepage {

    WebDriver driver;

    public Homepage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "search-catalog-navbar")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@class='title text-book-title']")
    public List<WebElement> searchResultTitles;

    @FindBy(xpath = "//div[@class='subtitle']")
    public List<WebElement> searchResultSubtitle;

    @FindBy(xpath = "//div[@class='details']")
    public List<WebElement> searchResultDescription;

    @FindBy(xpath = "//h1[@class='text-center']")
    public WebElement searchErrorMessage;
}
