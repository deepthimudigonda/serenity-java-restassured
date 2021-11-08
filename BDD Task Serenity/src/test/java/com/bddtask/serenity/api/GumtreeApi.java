package com.bddtask.serenity.api;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import io.restassured.response.Response;

public class GumtreeApi {
	
	public void sendGetRequest(String item, String size, int topAd, String locationId, String page, int redirected, int responseCode){
		
		//Create a Hashmap of query params
		HashMap<String, String> params = new HashMap<String, String>();
			params.put("keyword",item);
			params.put("size", size);
			params.put("locationId", locationId);
			params.put("page", page);
		
		//Get Request
		Response response = given()
							.queryParams(params)
							.queryParam("includeTopAds", topAd)
							.queryParam("Redirected", redirected)
							.get("https://ecg-api.gumtree.com.au/api/papi/ads/search")
							.then().statusCode(responseCode).extract().response();
		
		//Verify Response Code
		System.out.println(response.statusCode());
		Assert.assertTrue(response.statusCode()==responseCode);
		
		//Verify Response Type
		Assert.assertTrue(response.contentType().contains("application/json"));
		
		//Verify a Header
		Assert.assertTrue(response.header("Server").equals("rhino-core-shield"));
		
		//Verify size of ads
		if(responseCode==200){
			List<String> ads = response.jsonPath().getList("ads");
			int adsNum;
			adsNum = (topAd==1) ? Integer.valueOf(size)+2 : Integer.valueOf(size);
			Assert.assertTrue(ads.size()==adsNum);
		}
		
		//Verify that the first ad is a top ad
		if(topAd==1) {
			String features = response.jsonPath().getString("ads[0].featureList");
			Assert.assertTrue(features.contains("name:AD_GP_TOP_AD, display:true"));
		}
	}
}
