Feature: Ebay Advanced Search Page

  @P24
  Scenario: Ebay Logo on Advanced Search Page
    Given I am on Ebay Advanced Search Page
    When I click on Ebay Logo
    Then I am navigated to Ebay Home Page

  @P4 @setCookies
  Scenario: Advanced Search an Item
    Given I am on Ebay Advanced Search Page
    When I advanced search an item
      |keyword|exclude|min|max|
      |iPhone 11|refurbished|1000000|2000000|