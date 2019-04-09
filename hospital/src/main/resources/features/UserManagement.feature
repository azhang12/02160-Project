#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: User management
  I want to use this template for my feature file

  @tag1
  Scenario: Health Care Staff
    Given I am a health care staff role
    And I have the name of the person I want to search
    When I click the search button
    Then I see only the patient's admission and registration information if the name I searched was a patient
    And I cannot see the patient's personal data 
    And I cannot see any staff information

  @tag2
  Scenario Outline: Clerical Staff
    Given I am a Clerical staff role
    And I have the name of the person I want to search
    When I click the search button
    Then I see only the patient's admission and registration data if the name I searched was a patient
    And I cannot see the patient's personal information
    And I cannot see any staff's information
    
  @tag2
  Scenario Outline: ICT Officer
    Given I am a ICT Officer staff role
    And I have the name of the person I want to search
    When I click the search button
    Then I see only the person's data regardless if it is a patient or staff
    And I can see the patient's personal and admission information if the person is a patient
    And I can see staff information if the person is a staff

    Examples: 
      | healthcare  | patient name | personal and admission data  |
      | clerical |   patient name | admission data |
      | ict officer | patient or staff name | personal and admission and staff data  |
      | healthcare  | staff name | bad access |
      | clerical |   staff name | bad acess |
