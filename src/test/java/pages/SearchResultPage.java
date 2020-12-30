package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='significant-isbn']")
    public WebElement ISBNNumber;
}
