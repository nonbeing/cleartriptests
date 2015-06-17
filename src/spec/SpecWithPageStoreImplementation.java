package spec;

import domain.JourneyDetails;
import org.testng.Assert;
import pageFactoryWithPageStoreImpl.FlightsSearchPage;
import pageFactoryWithPageStoreImpl.LandingPage;
import pageFactoryWithPageStoreImpl.SearchResultsPage;
import scenarios.PageStore;


public class SpecWithPageStoreImplementation {


    LandingPage onLandingPage;
    FlightsSearchPage onFlightsSearchPage;
    SearchResultsPage onResultsPage;
    PageStore pageStore;


    public SpecWithPageStoreImplementation(PageStore pageStore) {
        this.pageStore = pageStore;
    }


    public SpecWithPageStoreImplementation(LandingPage onLandingPage) {
        this.onLandingPage = onLandingPage;
    }

    public void searchesForAOneWayJourneyWith(JourneyDetails journeyDetails) {
        FlightsSearchPage onFlightsSearchPage = pageStore.get(FlightsSearchPage.class);
        onFlightsSearchPage.searchForAOneWayJourneyWith(journeyDetails);
    }


    public void hasJourneyOptionsAvailableForHisOutboundJourney() {
    	SearchResultsPage page = pageStore.get(SearchResultsPage.class);
    	boolean x = page.resultsAppearForOutboundJourney();
//    	System.out.println("[DEBUG] x is: " + x);
        Assert.assertTrue(x);
    }

    public void searchesForAReturnJourneyWith(JourneyDetails journeyDetails) {
        FlightsSearchPage onFlightsSearchPage = pageStore.get(FlightsSearchPage.class);
        onFlightsSearchPage.searchForAReturnJourneyWith(journeyDetails);
    }

    public void hasJourneyOptionsAvailableForTheReturnJourney() {
        SearchResultsPage onResultsPage = pageStore.get(SearchResultsPage.class);
        Assert.assertTrue(onResultsPage.resultsAppearForOutboundJourney());
        Assert.assertTrue(onResultsPage.resultsAppearForInboundJourney());
    }

    public void choosesToDoAFlightSearch() {
        LandingPage onLandingPage = pageStore.get(LandingPage.class);
        onLandingPage.goToFlightsSearchPage();
    }
}
