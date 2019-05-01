# Eunjin Yoo
Feature: Find staff
	Description: Staff finds a staff from the database
	Actor: staff

Background: The staff database has a set of staff
	Given these staffs are contained in the staff database
		|1	|	Eunjin	|	Yoo		|	doctor	|	yoo@hospital.com		|
		|2	|	Kilian	|	Speiser	|	nurse	|	speiser@hospital.com	|
		|3	|	Kilian	|	Smith	|	ITC		|	smith@hospital.com		|
		|4	|	Taylor	|	Gregory	|	clerk	|	gregory@hospital.com	|

# Main scenario
Scenario: The staff finds a staff with first name
	Given the staff is logged in
	When the staff search for staff with "Kilian"
	Then staff2 and staff3 are found
	
	
Scenario: The staff finds a staff with last name
	Given the staff is logged in
	When the staff search for staff with "Yoo"
	Then staff1 is found


Scenario: The staff finds a staff with keyword
	Given the staff is logged in
	When the staff search for staff with "n"
	Then staff1 and staff2 and staff3 are found


Scenario: The staff finds a staff with e-mail address
	Given the staff is logged in
	When the staff search for staff with "yoo@hospital.com"
	Then staff1 is found
	

Scenario: The staff finds a staff with job role
	Given the staff is logged in
	When the staff search for staff with "clerk"
	Then staff4 is found
	
	
# Alternative scenarios
Scenario: The staff finds a staff that does not exist 
	Given the staff is logged in
	When the staff search for with "Elizabeth"
	Then the staff is not found
	And the staff get error message "Staff not found."