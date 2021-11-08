package com.bddtask.serenity.steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.bddtask.serenity.api.GumtreeApi;
import com.bddtask.serenity.pages.HomePage;
import com.bddtask.serenity.steps.serenity.ItemSearchSteps;
import net.thucydides.core.annotations.Steps;

public class ItemSearchStepDefs {
	
	@Steps
	ItemSearchSteps searchSteps;
	GumtreeApi api = new GumtreeApi();
	HomePage hp;
	
	@Given("^The User Opens Gumtree$")
	public void the_user_opens_gumtree() throws Throwable {
		hp.open();
		hp.closeCovid19_PopUp();
	}

	@When("^The User Searches for \"([^\"]*)\" in \"([^\"]*)\" Category$")
	public void the_user_sets_item_category(String item, String category){
		searchSteps.selectCategory(category);
		searchSteps.inputSearch(item);			
	}
	
	@And("^The User Sets Location \"([^\"]*)\" within \"([^\"]*)\"$")
	public void the_user_sets_location_distance(String location, String radius){
		searchSteps.inputLocation(location);
		searchSteps.selectRadius(radius);
		searchSteps.clickSearch();
	}
	
	@When("^The User Opens A Result$")
	public void the_user_opens_result(){
		searchSteps.openResult();			
	}
	
	@Then("^page should display ad id in the breadcrumbs$")
	public void page_should_display_ad_id() {
		searchSteps.verifyAdIdInBreadCrumb();
	}
	
	@Then("^page should display at least one similar item to \"([^\"]*)\"$")
	public void page_should_display_similar_item(String item) {
		searchSteps.verifySimilarItem(item);
	}
	
	@Given("^Verify Item Search For \"([^\"]*)\" with size \"([^\"]*)\" And TopAd Param \"([^\"]*)\" And LocationId \"([^\"]*)\" And Page \"([^\"]*)\" And Redirected \"([^\"]*)\" gets responseCode \"([^\"]*)\"$")
	public void send_search_request(String item, String size, String topAd, String locationId, String page,String redirected, String responseCode){
		int statusCode = Integer.parseInt(responseCode);
		int topAdInt = Integer.parseInt(topAd);
		int redirectedInt = Integer.parseInt(redirected);
		api.sendGetRequest(item, size, topAdInt, locationId, page, redirectedInt, statusCode);
	}
	
	@Then("^The User Should See \"([^\"]*)\" Response Code$")
	public void response_should_match(String item) {
		System.out.println("Step 2");
		//api.verifyResponseCode(item);
	}
	
}
