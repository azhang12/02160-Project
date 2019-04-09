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
Feature: Clerk discharges Patient
	
	Actor: Clerk



  @tag1
  Scenario: Succesfull discharges
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And The clerk XXX	//what is XXX
		And the patient is admitted to any department 
    When A patient wants to leave the hospital
    Then the patient is dicharged
    And the status changes to discharged 	//Should we add 'status' to patient info?
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
	Scenario: The patient is not admitted
	Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive|
	And The clerk XXX
	And the patient is not admitted to any department
  Then Error message is shown on the screen
  And the clerk should review the input
  
