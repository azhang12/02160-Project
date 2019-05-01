# Eunjin Yoo
Feature: Register staff
	Description: The clerk registers a person as a staff
	Actor: clerk
	
Background: The staff database has a set of staff
	Given these staffs are contained in the staff database
		|1	|	Eunjin	|	Yoo		|	doctor	|	yoo@hospital.com		|
		|2	|	Kilian	|	Speiser	|	nurse	|	speiser@hospital.com	|
		|3	|	Kilian	|	Smith	|	ITC		|	smith@hospital.com		|
		|4	|	Taylor	|	Gregory	|	clerk	|	gregory@hospital.com	|

# Main scenario
Scenario: The clerk registers a new staff 
	Given the clerk is logged in
	And a staff with |	Apple	|	Park	| ITC |
	When The clerk registers the staff
	Then the registration succeeds
	And the staff is registered
	And staffNumber of the staff is 5
	And staffEmail of the staff is "park@hospital.com"
	

# Alternative scenario
Scenario: The clerk registers a new staff with a surname that already exists
	Given the clerk is logged in
	And a staff with |	Brittany	|	Gregory	| ITC |
	When The clerk registers the staff
	Then the registration succeeds
	And the staff is registered
	And staffNumber of the staff is 5
	And staffEmail of the staff is "gregory1@hospital.com"