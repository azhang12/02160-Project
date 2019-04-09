# Eunjin Yoo 
Feature: Find staff
	Description: The clerk finds a staff from the database
	Actor: clerk

Background: The staff database has a set of staff
	Given these staffs are contained in the staff database
		|	Eunjin	|	Yoo		|	19900101	|	Avej 330	|	00000001	|	Korea		|	doctor	|
		|	Kilian	|	Speiser	|	19900101	|	Bvej 330	|	00000002	|	Germany		|	nurse	|
		|	Kilian	|	Smith	|	19881212	|	Cvej 330	|	00000003	|	Denmark		|	ITC		|
		|	Taylor	|	Gregory	|	19970101	|	Cvej 330	|	00000003	|	Australia	|	clerk	|

# Main scenario
Scenario: The clerk finds a staff with first name
	Given the clerk is logged in
	When the clerk search for staff with "Kilian"
	Then the staff "Kilian Speiser" and "Kilian Smith" are found
	
	
Scenario: The clerk finds a staff with last name
	Given the clerk is logged in
	When the clerk search for staff with "Yoo"
	Then the staff "Eunjin Yoo" is found


Scenario: The clerk finds a staff with keyword
	Given the clerk is logged in
	When the clerk search for staff with "n"
	Then the staff "Kilian Speiser" and "Kilian Smith" and "Eunjin Yoo" are found


Scenario: The clerk finds a staff with phone number
	Given the clerk is logged in
	When the clerk search for staff with "00000001"
	Then the staff "Eunjin Yoo" is found
	

Scenario: The clerk finds a staff with job role
	Given the clerk is logged in
	When the clerk search for staff with "doctor"
	Then the staff "Eunjin Yoo" and "Kilian Smith" are found
	
	
# Alternative scenarios
Scenario: The clerk finds a staff that does not exist 
	Given the clerk is logged in
	When the clerk search for with "Taylor"
	Then the the staff is not found
	And the clerk get error message "Staff not found."