Feature: Product Feature

  @Sanity @Short
  Scenario: Apply Lowest to Highest Order By
    Given I navigate to homepage
    And I order by lowest to highest
    Then I should see prices in ascending order