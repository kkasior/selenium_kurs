Feature: calculator
  Scenario: Adding two numbers
    Given I have a calculator
    When I add 1 and 2
    Then I should get 3
  Scenario: Michael orders a smoothie
    Given Michael is a morningFreshness member
    When He orders an "Apple and Kale smoothie"
    Then His order should be placed in the preparation queue