# Eunjin Yoo
Feature: Updatd staff
	Description: The clerk updates information of a staff
	Actor: clerk

Background: The staff database has a set of staff
	Given these staffs are contained in the staff database
		|	Eunjin	|	Yoo		|	19900101	|	Avej 330	|	00000001	|	Korea		|	doctor	|
		|	Kilian	|	Speiser	|	19900101	|	Bvej 330	|	00000002	|	Germany		|	nurse	|
		|	Kilian	|	Smith	|	19881212	|	Cvej 330	|	00000003	|	Denmark		|	ITC		|
		|	Taylor	|	Gregory	|	19970101	|	Cvej 330	|	00000003	|	Australia	|	clerk	|

# Main scenario
Scenario: The clerk updates first name of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with first name "Kilian"
	Then the update succeeds
	And the staff is updated


Scenario: The clerk updates last name of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with last name "Smith"
	Then the update succeeds
	And the staff is updated
	

Scenario: The clerk updates birthdate of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with birthdate 19990303
	Then the update succeeds
	And the staff is updated


Scenario: The clerk updates address of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with address "Bvej 111"
	Then the update succeeds
	And the staff is updated


Scenario: The clerk updates pholne number of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with phone number +4511111111
	Then the update succeeds
	And the staff is updated


Scenario: The clerk updates nationality of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with nationality "Denmark"
	Then the update succeeds
	And the staff is updated


Scenario: The clerk updates job role of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with job role "ITC"
	Then the update succeeds
	And the staff is updated


	
	
# Alternative scenarios
Scenario: The clerk updates an unique property of a staff 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with ###################
	Then the update fails
	And the user get error message "Cannot be changed."
	And the staff is not updated

	
Scenario: The clerk updates phone number of a staff to another number that already exists
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk updates the staff with phone number 00000002
	Then the update fails
	And the user get error message "Phone number already exists"
	And the staff is not updated