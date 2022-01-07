Feature: User Feature

  @Confidential
  Scenario: Login as User with no image loaded
    Given I navigate to homepage
    And I SignIn as "image_not_loading_user" with "testingisfun99" password
    Then I should see no image loaded

  @Confidential @Random
  Scenario: Login as User with existing Orders
    Given I navigate to homepage
    And I SignIn as "existing_orders_user" with "testingisfun99" password
    And I click on "Orders" link
    Then I should see elements in list
