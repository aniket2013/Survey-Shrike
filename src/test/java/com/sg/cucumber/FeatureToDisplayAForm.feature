Feature: Display a form using the application
  As a user of Survey-Shrike application
  I want to create a form for survey.

  Scenario Outline: Form displaying from a web application
    Given the name of the form is <formName>
    And the id of the form is <formId>
    When I perform display form operation
    Then the message is "1"

    Examples: 
      | formName | formId |
      | Form1    |     01 |
      | Form2    |     02 |
      | Form3    |     03 |
