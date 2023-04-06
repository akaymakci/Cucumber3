Feature:  Citizenship with scenario Outline

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship page

  Scenario Outline: Citizenship create
    When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
    Then Success message should be displayed

    When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
    Then Already exist message should be displayed
    And Click on close button

    When User delete the "<CitizenshipName>"
    Then Success message should be displayed

    Examples:
      | CitizenshipName | ShortName |
      | vatan1aa        | vat1      |
      | vatan2aa        | vat2      |
      | vatan3aa        | vat3      |
      | vatan4aa        | vat4      |
      | vatan5aa        | vat5      |


