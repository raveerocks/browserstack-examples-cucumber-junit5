Feature: Offers Feature

  @Confidential
  Scenario: Offers for Mumbai location
    Given I navigate to homepage
    And I SignIn as "fav_user" with "testingisfun99" password
    And I click on "Offers" link
    Then I should see Offer elements
