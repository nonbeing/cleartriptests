package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.WaitFor;

import java.util.List;

public class FlightsSearchPage {
    WebDriver driver;

    public FlightsSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseToHaveAOneWayJourney() {
        driver.findElement(By.id("OneWay")).click();
    }

    public void enterDepartureDateAs(String date) {
        driver.findElement(By.id("FromDate")).clear();
        driver.findElement(By.id("FromDate")).sendKeys(date);
    }

    public void enterReturnDateAs(String date) {
        driver.findElement(By.id("ToDate")).clear();
        driver.findElement(By.id("ToDate")).sendKeys(date);
    }


    public void enterDestinationAs(String destination) {
        driver.findElement(By.id("To")).clear();
        driver.findElement(By.id("To")).sendKeys(destination);
    }


    public void enterOriginAs(String origin) {
        driver.findElement(By.id("From")).clear();
        driver.findElement(By.id("From")).sendKeys(origin);
    }




    public void chooseToHaveAReturnJourney() {
        driver.findElement(By.id("RoundTrip")).click();
    }


    public void selectTheFirstAvailableAutoCompleteOption() {
        //Conditional wait - wait for element to be present
        WebElement autocompleteOptionsContainer = new WaitFor(driver).presenceOfTheElement(By.id("autocompleteOptionsContainer"));

        //select the first item from the auto complete list
        List<WebElement> optionsList = autocompleteOptionsContainer.findElements(By.tagName("li"));
        optionsList.get(0).click();

    }

    public SearchResultsPage searchForTheJourney() {
        driver.findElement(By.id("SearchBtn")).click();
        return new SearchResultsPage(driver);
    }

}
