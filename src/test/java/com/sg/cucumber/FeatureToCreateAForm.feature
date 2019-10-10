Feature: Create a form using the application
  As a user of Survey-Shrike application
  I want to create a form for survey.

  Scenario Outline: Form creation from a web application
    Given the form name is <formName>
    And the form Id id <formId>
    And the textbox1 is <textbox>
    And the checkbox1 is <checkbox>
    When I perform create form operation
    Then I have a form with the Id as "<createdformId>"

    Examples: 
      | formName | formId | textbox | checkbox | createdformId |
      | Form1    |     01 | T01     | C01      |            01 |
      | Form2    |     02 | T02     | C02      |            02 |
      | Form3    |     03 | T01     | C02      |            03 |
