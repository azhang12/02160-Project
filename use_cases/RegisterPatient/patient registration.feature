Feature: Register patient
	Description: The clerk registers a person as a patient
	Actor: clerk

Background: The patient database has a set of patients
	Given these patients are contained in the patient database  
		|	Jane	|	Doe	| 19960101 | electrovej 330 | 00000000 | Australian | alive |

# Main scenario
Scenario: The clerk registers a new patient 
	Given the clerk is logged in
	And a patient with |	Eunjin	|	Yoo	| 19970101 | electrovej 330 | 00000000 | Australian | alive |
	When The clerk registers the patient
	Then the registration succeeds
	And the patient is registered
	
	
# Failing scenario
Scenario: The clerk registers a patient that already exists 
	Given the clerk is logged in
	And a patient with |	Jane	|	Doe	| 19960101 | electrovej 330 | 00000000 | Australian | alive |
	When The clerk registers the patient
	Then the registration fails
	And the user get error message "Already exists"
	And patient is registered