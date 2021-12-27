Feature: Ebay Home Page Scenarios

  @P1
  Scenario: Advanced search link
    Given I am on Ebay Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search Page

  @P2
  Scenario: Search items count
    Given I am on Ebay Home Page
    When I search for 'iPhone 11'
    Then I validate at least 1000 search items present

  @P2
  Scenario: Search items count
    Given I am on Ebay Home Page
    When I search for 'samsung galaxy'
    Then I validate at least 100 search items present