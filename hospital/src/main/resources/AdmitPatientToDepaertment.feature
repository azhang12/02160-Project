#Author: kilian.speiser@tum.de
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
Feature: Clerk admits Patient to department
	
	Actor: Clerk



  @tag1
  Scenario: Succesfull admitted
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And The clerk XXX
		And the patient is not admitted to any department
    When patient arrives at Reception
    Then the patient is admitted to a department
    And the bed status changes to admitted to department
    And the Patient and Department Database is updated
    And the GUI shows a successfully allocated Patient
    
    
    @Failure1
	Scenario: The worker trying to do the operation is not a clerk
	Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive|
	And The nurse XXX
	And the patient is not admitted to any department
  Then Error message is shown on the screen
  And the clerk should review the input
  
  @Failure2
	Scenario: The patient is already admitted
	Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive|
	And The clerk XXX
	And the patient is admitted to any department
  Then Error message is shown on the screen
  And the clerk should review the input
  
