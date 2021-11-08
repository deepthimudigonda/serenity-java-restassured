package com.bddtask.serenity.pages;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.gumtree.com.au/")

public class HomePage extends PageObject {
	
	@FindBy (css="[title='close']")
	private WebElementFacade covidPopUp;
	
	@FindBy (css="#search-query")
	private WebElementFacade searchInput;
	
	@FindBy (css=".search-bar__category-name")
	private WebElementFacade categoryDropdown;
	
	@FindBy (xpath="//ul[ancestor::div[contains(@class,\"search-category\")] and @class=\"j-selectbox__ul\"]")
	private WebElementFacade categoryList;
	
	@FindBy (css="#search-area")
	private WebElementFacade locationInput;
	
	@FindBy (css="#srch-radius-input")
	private WebElementFacade radiusDropdown;
	
	@FindBy (xpath="//ul[ancestor::div[contains(@class,\"location-radius\")] and @class=\"j-selectbox__ul\"]")
	private WebElementFacade radiusList;
	
	@FindBy (css="[type='submit']")
	private WebElementFacade searchButton;
	
	//Close Covid 19 Pop Up
	public void closeCovid19_PopUp(){
		covidPopUp.click();
	}
	
	//Set Search Item
	public void inputSearch_PO(String item){
		searchInput.sendKeys(item);
		//searchInput.sendKeys(Keys.TAB);
	}
	
	//Set Category
	public void selectCategory_PO(String category){
		categoryDropdown.click();
		
		//Select category(li) from category list(ul)
		List<WebElement> options = categoryList.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
			WebElement optionLi = option.findElement(By.className("j-selectbox__text"));
		    if (optionLi.getText().equals(category))
		    {	
		        option.click();
		        break;
		    }
		}
	}
	
	//Set Location
	public void inputLocation_PO(String location){
		locationInput.sendKeys(location);
	}
	
	//Set Radius
	public void selectRadius_PO(String radius){
		radiusDropdown.click();
		
		//Select radius(li) from radius list(ul)
		List<WebElement> options = radiusList.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals(radius))
		    {
		        option.click();
		        break;
		    }
		}
	}
	
	//Click Search button
	public void clickSearch_PO(){
		searchButton.click();
	}
}