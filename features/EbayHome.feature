Feature: Ebay Home Page Scenarios

  @P1
  Scenario: Advanced search link
    Given I am on Ebay Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search Page

  @P2 @setCookies
  Scenario: Search items count
    Given I am on Ebay Home Page
    When I search for 'iPhone 11'
    Then I validate at least 1000 search items present

  @P2 @setCookies
  Scenario: Search items count
    Given I am on Ebay Home Page
    When I search for 'samsung galaxy'
    Then I validate at least 100 search items present

  @P3 @setCookies
  Scenario: Search for item in category
    Given I am on Ebay Home Page
    When I search for 'jabón' in 'Bebés' category
    Then I validate at least 20 search items present

  @P5
  Scenario Outline: Home Page links
    Given I am on Ebay Home Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'
    Examples:
      | link | url | title |
      |Vehículos|https://co.ebay.com/b/Auto-Parts-Accessories/6028/bn_569479|Auto PARTS|
      |Moda     |https://co.ebay.com/b/Fashion/bn_7000259856                |Moda      |
      |Tecnología|https://co.ebay.com/b/Electronics/bn_7000259124           |Electronics|
      |Equipo industrial|https://co.ebay.com/b/Business-Industrial/12576/bn_1853744|maquinaria industrial|
