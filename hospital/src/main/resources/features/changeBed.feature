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
Feature: Move patient to other bed
	
	Actor: Nurse




  @tag1
  Scenario: Bed changed successfully
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And The nurse YYY works at a inpatient department
		And the patient is admitted to the department the nurse is working for
		And the patient is assigned to a bed
    When A doctor nurse moves patient to another bed
    Then the current bed is set as available
    And the new bed is occupied
    And the Patient's bed is updated
    And the Patient and Department database is updated
    And the GUI shows a successfully moved patient
    
  @Failure1
  Scenario: nurse not working for inpatient department
  Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
  And The nurse YYY works not at a inpatient department
	And the patient is admitted to the department the nurse is working for
	And the patient is assigned to a bed
  When A doctor nurse moves patient to another bed
  Then the operation is not valid
  And the nurse has to review
  
  @Failure2
  Scenario: patient not admitted to the department the nurse is working for
  Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
  And The nurse YYY works at a inpatient department
	And the patient is not admitted to the department the nurse is working for
	And the patient is assigned to a bed
  When A doctor nurse moves patient to another bed
  Then the operation is not valid
  And the nurse has to review
  @Failure3:
  Scenario: patient is not assigned to a bed
  Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
  And The nurse YYY works at a inpatient department
	And the patient is admitted to the department the nurse is working for
	And the patient is not assigned to a bed
  When A doctor nurse moves patient to another bed
  Then the operation is not valid
  And the nurse has to review
  

  