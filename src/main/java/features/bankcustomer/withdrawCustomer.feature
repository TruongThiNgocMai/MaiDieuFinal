
Feature: Customer withdraw

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
    When I login successfully with username as Harry Potter
    When I verify user input Deposit successful with 2000

  Scenario Outline: Customer withdraw Successfully
    When I open withdraw tab
    When I type withdraw as <withdraw>
    And  I click withdraw submit button
    Then I verify amount input of Withdraw
    Then I click Transaction to navigate to Transaction Tab
    Then I verify that customer withdraw successfully as <withdraw>

    Examples:
      | withdraw |
      | 1000     |

  Scenario Outline: Customer withdraw unSuccessfully
    When I open withdraw tab
    When I type withdraw as <withdraw>
    And  I click withdraw submit button
    Then I verify amount input of Withdraw
    Then I click Transaction to navigate to Transaction Tab
    Then I verify that customer withdraw unsuccessfully as <withdraw>

    Examples:
      | withdraw |
      | 5000     |