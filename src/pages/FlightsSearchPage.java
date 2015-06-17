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
        driver.findElement(By.id("DepartDate")).clear();
        driver.findElement(By.id("DepartDate")).sendKeys(date);
    }

    public void enterReturnDateAs(String date) {
        driver.findElement(By.id("ReturnDate")).clear();
        driver.findElement(By.id("ReturnDate")).sendKeys(date);
    }


    public void enterDestinationAs(String destination) {
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys(destination);
    }


    public void enterOriginAs(String origin) {
        driver.findElement(By.id("FromTag")).clear();
        driver.findElement(By.id("FromTag")).sendKeys(origin);
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
