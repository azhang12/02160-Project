# Eunjin Yoo
Feature: Updatd staff
	Description: The clerk updates information of a staff
	Actor: clerk

Background: The staff database has a set of staff
	Given these staffs are contained in the staff database
		|1	|	Eunjin	|	Yoo		|	19900101	|	Avej 330	|	00000001	|	Korea		|	doctor	|
		|2	|	Kilian	|	Speiser	|	19900101	|	Bvej 330	|	00000002	|	Germany		|	nurse	|
		|3	|	Kilian	|	Smith	|	19881212	|	Cvej 330	|	00000003	|	Denmark		|	ITC		|
		|4	|	Taylor	|	Gregory	|	19970101	|	Cvej 330	|	00000003	|	Australia	|	clerk	|


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
	

Scenario: The clerk updates birthdate of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with birthdate 19990303
	Then the update succeeds
	And staff1 is updated


Scenario: The clerk updates address of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with address "Bvej 111"
	Then the update succeeds
	And staff1 is updated


Scenario: The clerk updates pholne number of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with phone number 11111111
	Then the update succeeds
	And staff1 is updated


Scenario: The clerk updates nationality of a staff 
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with nationality "Denmark"
	Then the update succeeds
	And staff1


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

	
Scenario: The clerk updates phone number of a staff to another number that already exists
	Given the clerk is logged in
	And staff1
	When The clerk updates the staff with phone number 00000002
	Then the update fails
	And the user get error message "Phone number already exists"
	And staff1 is not updated
	

Scenario: The clerk updates her/his own job role
	Given the clerk is logged in
	And staff4
	When The clerk updates the staff with job role "nurse"
	Then the update fails
	And the user get error message "Your own job role cannot be changed."
	And staff4 is not updated