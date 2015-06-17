package pageFactoryWithPageStoreImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@data-leg='1']")
	private WebElement outboundResultDiv;

	@FindBy(xpath = "//div[@data-leg='2']")
	private WebElement inboundResultDiv;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean resultsAppearForInboundJourney() {
		waitForSearchResultsToAppear();
		boolean result = inboundResultDiv == null ? false : true;
		return result;
	}

	public boolean resultsAppearForOutboundJourney() {
		waitForSearchResultsToAppear();
		boolean result = outboundResultDiv == null ? false : true;
		return result;
	}

	private void waitForSearchResultsToAppear() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".resultContainer")));
	}

//	private ExpectedCondition<WebElement> visibilityOfElementLocated(
//			final By locator) {
//		return new ExpectedCondition<WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				WebElement toReturn = driver.findElement(locator);
//				if (toReturn.isDisplayed()) {
//					return toReturn;
//				}
//				return null;
//			}
//		};
//	}

//	private boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}

}
