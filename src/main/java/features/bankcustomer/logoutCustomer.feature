Feature: Customer Login
Background:
  Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
  When I login successfully with username as Harry Potter

  Scenario: Customer Login Successfully
    When I click Logout Button
    Then I verify that user logout successfully