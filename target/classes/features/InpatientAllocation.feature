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
Feature: Allocation of Inpation by Nurse
	Description: Nurse allocates patient at inpatient department to a bed
	Actor: Nurse



  @tag1
  Scenario: Succesfull allocation
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And this patient was admitted to a inpatient department by the clerk
    And This patient is not allocated to a bed
    And the bed the patient is allocated to is free
    And the patient is alive
    And the nurse is working for the departement
    And the patient is admitted to the department the nurse is working for
    When patient arrives at inpatient department
    Then the patient is assigned to the bed
    And the bed status changes to occupied
    And the Patient and Department Database is updated
    And the GUI shows a successfully allocated Patient
    
    
    @Failure1
	Scenario: Patient was admitted to a outpatient department
	Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive|
	And this patient was admitted to a outpatient department by the clerk
  And This patient is not allocated to a bed
  And the bed the patient is allocated to is free
  And the patient is alive
  And the nurse is working for the departement
  And the patient is admitted to the department the nurse is working for
  When patient arrives at inpatient department
  Then Error message is shown on the screen
  And the nurse should review the input
  
  @Failure2
	Scenario: Patient is already allocated to a bed
	Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive|
	And this patient was admitted to a inpatient department by the clerk
  And This patient is allocated to a bed
  And the bed the patient is allocated to is free
  And the patient is alive
  And the nurse is working for the departement
  And the patient is admitted to the department the nurse is working for
  When patient arrives at inpatient department
  Then Error message is shown on the screen
  And the nurse should review the input
  
  @Failure3
   Scenario: The bed is not free
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And this patient was admitted to a inpatient department by the clerk
    And This patient is not allocated to a bed
    And the bed the patient is allocated to is occupied
    And the patient is alive
    And the nurse is working for the departement
    And the patient is admitted to the department the nurse is working for
    When patient arrives at inpatient department
    Then Error message is shown on the screen
  And the nurse should review the input
    


	@Failure4
	Scenario: Patient dead
	Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | dead|
	And this patient was admitted to a inpatient department by the clerk
  And This patient is not allocated to a bed
  And the bed the patient is allocated to is free
  And the patient is alive
  And the nurse is working for the departement
  And the patient is admitted to the department the nurse is working for
  When patient arrives at inpatient department
  Then Error message is shown on the screen
  And the nurse should review the input
  
  @Failure5 
  Scenario: The nurse doesn't work for the department she wants to assign the patient to
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And this patient was admitted to a inpatient department by the clerk
    And This patient is not allocated to a bed
    And the bed the patient is allocated to is free
    And the patient is alive
    And the nurse is working for a different department
    And the patient is admitted to the department the nurse is working for
    When patient arrives at inpatient department
    Then Error message is shown on the screen
  	And the nurse should review the input
  	
  	@Failure6
    Scenario: The patient is not admitted to the department the nurse wants them allocate to
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And this patient was admitted to a inpatient department by the clerk
    And This patient is not allocated to a bed
    And the bed the patient is allocated to is free
    And the patient is alive
    And the nurse is working for the departement
    And the patient is not admitted to the department the nurse is working for
    When patient arrives at inpatient department
    Then Error message is shown on the screen
  	And the nurse should review the input
  
	