Feature: Search for an item in Gumtree
As a user
I want to search for an item in a specific category, location and radius
then when I select a search result, I should see ad id in the bread crumbs and similar items in the page

@uiTest
Scenario: Gumtree Item Search - UI
Given The User Opens Gumtree
When The User Searches for "Sennheiser headphones" in "Electronics & Computer" Category
And The User Sets Location "Sydney Region" within "20km"
When The User Opens A Result
Then page should display ad id in the breadcrumbs
And page should display at least one similar item to "Sennheiser"

@apiTest
Scenario Outline: Gumtree Item Search - API
Given Verify Item Search For "<item>" with size "<size>" And TopAd Param "<topAd>" And LocationId "<locationId>" And Page "<page>" And Redirected "<redirected>" gets responseCode "<statusCode>"

Examples:
|item|size|topAd|locationId|page|redirected|statusCode|
|Table|20|1|3003435|1|1|200|
|Table|20|5|3003435|1|1|400|
|Table|20|0|3003435|1|1|200|