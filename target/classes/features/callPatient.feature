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
Feature: Call patient
	
	Actor: doctor



  @tag1
  Scenario: Called patient succesfully
    Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
    And The doctor YYY works at a outpatient department
		And the patient is admitted to the department the doctor is working for
		And the patient has a number to queue
		And the number called is assigned to the patient
    When A doctor calls the patient at the outpatient department
    Then the patient queing number is removed
    And the status changes
    And the Patient and Department Database is updated
    And the GUI shows a successfully called patient
    
   @Failure1
   Scenario: doctor YYY does not work at outpatient deparmtent
   Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
	  And The doctor YYY works not at a outpatient department
		And the patient is admitted to the department the doctor is working for
		And the patient has a number to queue
		And the number called is assigned to the patient
	  When A doctor calls the patient at the outpatient department
	  Then the the GUI shows an error "Operation not allowed due to system restirctions"
	  And the doctor should try a differetn operation
	  
	  @Failure2
   Scenario: Patient not at this department
   Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
	  And The doctor YYY works at a outpatient department
		And the patient is admitted to ta different department
		And the patient has a number to queue
		And the number called is assigned to the patient
	  When A doctor calls the patient at the outpatient department
	  Then the the GUI shows an error "Patient not at your department"
	  And the doctor should review
	  
	  @Failure3
   Scenario: No number to queue
   Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
	  And The doctor YYY works at a outpatient department
		And the patient is admitted to the department the doctor is working for
		And the patient has no number to queue
		And the number called is assigned to the patient
	  When A doctor calls the patient at the outpatient department
	  Then the the GUI shows an error "Patient is not waiting"
	  And the doctor should review
	  
	   @Failure4
   Scenario: Not called number
   Given The patient: |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000001 | Australian | alive |
	  And The doctor YYY works at a outpatient department
		And the patient is admitted to the department the doctor is working for
		And the patient has a number to queue
		And the number called is not assigned to the patient
	  When A doctor calls the patient at the outpatient department
	  Then the the GUI shows an error "Number does not correspond to Patient"
	  And the doctor should review
 
  
  