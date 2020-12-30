package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Homepage;
import pages.SearchResultPage;
import utilities.Configuration;
import utilities.Driver;

public class Steps {

    WebDriver driver = Driver.getDriver();
    Homepage homepage = new Homepage();
    SearchResultPage searchRPage = new SearchResultPage();
    String ISBNNumber = "";

    @Given("^user navigates to RedShelf application$")
    public void user_navigates_to_Red_Shelf_application() throws Throwable {
        driver.get(Configuration.getProperty("URL"));
    }

    @When("^user searches for \"([^\"]*)\" book$")
    public void user_searches_for_book(String book) throws Throwable {
        homepage.searchBox.sendKeys(book+ Keys.ENTER);
    }

    @Then("^user validates search results contains \"([^\"]*)\" keyword$")
    public void user_validates_search_results_contains_keyword(String bookTitle)  throws Throwable {
        long numberOfMatchedKeywords =
                homepage.searchResultTitles.stream()
                        .filter(element -> element.getText().toLowerCase().contains(bookTitle.toLowerCase()))
                        .count()
                +
                homepage.searchResultSubtitle.stream()
                        .filter(element -> element.getText().toLowerCase().contains(bookTitle.toLowerCase()))
                        .count()
                +
                homepage.searchResultDescription.stream()
                        .filter(element -> element.getText().toLowerCase().contains(bookTitle.toLowerCase()))
                        .count();
        Assert.assertTrue(numberOfMatchedKeywords>0);
    }

    @Then("^user validates error message \"([^\"]*)\"$")
    public void user_validates_error_message(String errorMessage) throws Throwable {
        String actualErrorMessage = homepage.searchErrorMessage.getText();
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }

    @When("^user click on book and stores ISBN number$")
    public void user_click_on_book_and_stores_ISBN_number() throws Throwable {
        homepage.searchResultTitles.get(0).click();
        ISBNNumber = searchRPage.ISBNNumber.getText();
        ISBNNumber = ISBNNumber.substring(ISBNNumber.indexOf(":")+2);
    }

    @When("^user searches for stored ISBN number$")
    public void user_searches_for_stored_ISBN_number() throws Throwable {
        homepage.searchBox.sendKeys(ISBNNumber+Keys.ENTER);
    }

    @Then("^user validates \"([^\"]*)\" book in search result$")
    public void user_validates_book_in_search_result(String bookTitle) throws Throwable {
        String actualTitle = homepage.searchResultTitles.get(0).getText().toLowerCase();
        Assert.assertTrue(actualTitle.contains(bookTitle));
    }

}
