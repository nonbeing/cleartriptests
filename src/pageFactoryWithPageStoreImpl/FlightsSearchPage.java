package pageFactoryWithPageStoreImpl;

import com.google.common.base.Function;

import domain.JourneyDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsSearchPage {
    WebDriver driver;

    @FindBy(id = "OneWay")
    private WebElement oneWayJourneySelection;

    @FindBy(id = "RoundTrip")
    private WebElement returnTripJourneySelection;

    @FindBy(id = "DepartDate")
    private WebElement departureDateField;

    @FindBy(id = "ReturnDate")
    private WebElement returnDateField;

    @FindBy(id = "FromTag")
    private WebElement originField;

    @FindBy(id = "ToTag")
    private WebElement destinationField;

    @FindBy(id = "SearchBtn")
    private WebElement searchButton;
    
    @FindBy(id = "ui-id-1")
    private WebElement originAutocompleteDropdown;

    @FindBy(id = "ui-id-2")
    private WebElement destinationAutocompleteDropdown;

    public FlightsSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseToHaveAOneWayJourney() {
        oneWayJourneySelection.click();
    }


    public void enterDepartureDateAs(String date) {
        departureDateField.clear();
        departureDateField.sendKeys(date);
        departureDateField.sendKeys(Keys.TAB);
    }

    public void enterReturnDateAs(String date) {
        returnDateField.clear();
        returnDateField.sendKeys(date);
    }


    public void enterDestinationAs(String destination) {
        destinationField.clear();
        destinationField.sendKeys(destination);
    }


    public void enterOriginAs(String origin) {
        originField.clear();
        originField.sendKeys(origin);
    }

    
    public void enterOriginAndSelectAutocomplete(String origin) {
    	originField.clear();
    	originField.sendKeys(origin);
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.elementToBeClickable(originAutocompleteDropdown)) ;
    	
    	//select the first item from the auto complete list
    	WebElement originOptionsElement = originAutocompleteDropdown;
    	List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
    	originOptions.get(0).click();
    }
    
    
    public void enterDestinationAndSelectAutocomplete(String destination) {
    	destinationField.clear();
    	destinationField.sendKeys(destination);
        
        
    	WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(destinationAutocompleteDropdown)) ;
        
        //select the first item from the auto complete list
        WebElement destOptionsElement = destinationAutocompleteDropdown;
        List<WebElement> destOptions = destOptionsElement.findElements(By.tagName("li"));
        destOptions.get(0).click();
    }

    
    public void chooseToHaveAReturnJourney() {
        returnTripJourneySelection.click();
    }


    public void selectTheFirstAvailableAutoCompleteOption(String id) {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        
        WebElement optionListElement = driver.findElement(By.id(id));
        
        //select the first item from the auto complete list
        WebElement originOptionsElement = optionListElement;
        List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }

    public void searchForAOneWayJourneyWith(JourneyDetails journeyDetails) {
        this.chooseToHaveAOneWayJourney();
        this.enterOriginAndSelectAutocomplete(journeyDetails.getOrigin());
        this.enterDestinationAndSelectAutocomplete(journeyDetails.getDestination());
        this.enterDepartureDateAs(journeyDetails.getDepartureDate());
        
        searchButton.click();
    }

    public void searchForAReturnJourneyWith(JourneyDetails journeyDetails) {
        this.chooseToHaveAReturnJourney();
        
        this.enterOriginAndSelectAutocomplete(journeyDetails.getOrigin());
        this.enterDestinationAndSelectAutocomplete(journeyDetails.getDestination());
        this.enterDepartureDateAs(journeyDetails.getDepartureDate());
        this.enterReturnDateAs(journeyDetails.getReturnDate());
        searchButton.click();
    }


}
