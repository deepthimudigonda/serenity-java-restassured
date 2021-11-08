package com.bddtask.serenity.steps.serenity;

import com.bddtask.serenity.pages.HomePage;
import com.bddtask.serenity.pages.ResultsPage;
import com.bddtask.serenity.pages.AdPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ItemSearchSteps extends ScenarioSteps {

	HomePage hp;
	ResultsPage rp;
	AdPage ap;
	
	@Step
	public void openHomePage(){
		hp.open();
	}

	
	@Step
	public void inputSearch(String item){
		hp.inputSearch_PO(item);
	}
	
	@Step
	public void selectCategory(String category){
		hp.selectCategory_PO(category);
	}
	
	@Step
	public void inputLocation(String location){
		hp.inputLocation_PO(location);
	}
	
	@Step
	public void selectRadius(String radius){
		hp.selectRadius_PO(radius);
	}
	
	@Step
	public void clickSearch(){
		hp.clickSearch_PO();
	}
	
	@Step
	public void openResult(){
		rp.openRandomSearchResult_PO();
	}
	
	@Step 
	public void verifyAdIdInBreadCrumb() {
		ap.verifyAdId();
	}
	
	@Step
	public void verifySimilarItem(String item) {
		ap.verifySimilarItem(item);
	}
}