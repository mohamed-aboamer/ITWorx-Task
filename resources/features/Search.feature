@create-course-feature
Feature: As a user I want to do create course at winjigo website

  @creation
  Scenario Outline: check the create course functionality
    Given user open winjigo website
    And user sign in with valid "<username>" username and "<password>" password
    When open courses page from left side navigation bar
    And click on create course button
    And fill course basic info then click save
    Then course title is displayed in courses list page


    Examples:
      | username | password |
      | testregister@aaa.com  | Wakram_123 |

