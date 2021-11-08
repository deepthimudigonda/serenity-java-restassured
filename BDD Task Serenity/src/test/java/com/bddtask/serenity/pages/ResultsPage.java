package com.bddtask.serenity.pages;
import java.util.List;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;


public class ResultsPage extends PageObject {

	
	@FindBy (xpath="//a[contains(@class,\"ad-row\")]")
	private List<WebElement> searchResult;
	
	//Open Random Search Result
	public void openRandomSearchResult_PO(){
		List<WebElement> results = searchResult;
		int max = results.size()-1;
		int min = 1;
		int index = (int)Math.floor(Math.random()*(max-min+1)+min);
		WebElement randomResult = getDriver().findElement(By.xpath("//a[contains(@class,\"ad-row\")]["+index+"]"));
		String adId = randomResult.getAttribute("id").substring(8);
		randomResult.click();
		AdPage.setAdId(adId);
	}
}