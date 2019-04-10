# Eunjin Yoo
Feature: Updatd staff
	Description: The clerk updates information of a staff
	Actor: clerk

Background: The staff database has a set of staff
	Given these staffs are contained in the staff database
		|1	|	Eunjin	|	Yoo		|	doctor	|	yoo@hospital.com		|
		|2	|	Kilian	|	Speiser	|	nurse	|	speiser@hospital.com	|
		|3	|	Kilian	|	Smith	|	ITC		|	smith@hospital.com		|
		|4	|	Taylor	|	Gregory	|	clerk	|	gregory@hospital.com	|
		

# Main scenario
Scenario: The clerk updates first name of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with first name "Kilian"
	Then the update succeeds
	And staff1 is updated


Scenario: The clerk updates last name of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with last name "Smith"
	Then the update succeeds
	And staff1 is updated
	

Scenario: The clerk updates job role of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with job role "ITC"
	Then the update succeeds
	And staff1 is updated

	
	
# Failing scenarios
Scenario: The clerk updates staffNumber of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with staffNumber 5
	Then the update fails
	And the user get error message "Staff number cannot be changed."
	And the staff is not updated


Scenario: The clerk updates staffEmail of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staffEmail with "wow@hospital.com"
	Then the update fails
	And the user get error message "Staff e-mail address cannot be changed."
	And the staff is not updated
	

Scenario: The clerk updates her/his own job role
	Given the clerk is logged in
	And staff4
	When The clerk updates the staff with job role "nurse"
	Then the update fails
	And the user get error message "Your own job role cannot be changed."
	And staff4 is not updated