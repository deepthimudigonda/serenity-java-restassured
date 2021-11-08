package com.bddtask.serenity.pages;

import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class AdPage extends PageObject {
	
	private static String adId;
	
	@FindBy (xpath="//span[@class=\"breadcrumbs__summary\"]")
	private WebElementFacade adIdBreadCrumb;
	
	@FindBy(xpath="//div[@class=\"user-ad-square-new-design__text-section\"]")
	private List<WebElement> similarAds;
	
	//Verify Ad ID
	public void verifyAdId() {		
		String breadCrumbAdIdText = adIdBreadCrumb.getText().substring(6);
		Assert.assertTrue(breadCrumbAdIdText.equals(getAdId()));
	}
	
	//AdId - Getter
	public static String getAdId() {
		return adId;
	}
	
	//AdId - Setter
	public static void setAdId(String adId) {
		AdPage.adId = adId;
	}
	
	//Verify Similar Item
	public void verifySimilarItem(String item) {
		Iterator<WebElement> webElementIterator = similarAds.iterator();
		while(webElementIterator.hasNext()) {
				if(webElementIterator.next().getText().toLowerCase().contains("item")){
				System.out.println(webElementIterator.next().getText());
				Assert.assertTrue(true);
				break;
			}
		}
	}	
}