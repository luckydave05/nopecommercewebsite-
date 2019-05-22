@register
Feature: User should able to register successfully,
  So that he can use all user features from website.


  Scenario: User should able to register

    Given  user is on homepage and click register page
    When  user enter all mandatory details
    Then user should be able to register sucessfully