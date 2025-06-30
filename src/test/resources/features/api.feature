Feature: API Testing Examples


  @API
  Scenario: Verify GET call for users
    When I send GET request to "https://automationexercise.com/api/productsList"
    Then Response status code should be 200
    And Response should contain "products"

  @API
  Scenario: Verify Product brands
    When I send GET request to "https://automationexercise.com/api/brandsList"
    Then Response status code should be 200
    And Response should contain brands:
      | Polo                |
      | H&M                 |
      | Madame              |
      | Mast & Harbour      |
      | Babyhug             |
      | Allen Solly Junior  |
      | Kookie Kids         |
      | Biba                |


