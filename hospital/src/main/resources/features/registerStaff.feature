# Eunjin Yoo
Feature: Register staff
	Description: The clerk registers a person as a staff
	Actor: clerk

Background: The staff database has a set of staff
	Given these staffs are contained in the staff database
		|	Eunjin	|	Yoo		|	19900101	|	Avej 330	|	00000001	|	Korea		|	doctor	|
		|	Kilian	|	Speiser	|	19900101	|	Bvej 330	|	00000002	|	Germany		|	nurse	|
		|	Kilian	|	Smith	|	19881212	|	Cvej 330	|	00000003	|	Denmark		|	ITC		|
		|	Taylor	|	Gregory	|	19970101	|	Cvej 330	|	00000003	|	Australia	|	clerk	|

# Main scenario
Scenario: The clerk registers a new staff 
	Given the clerk is logged in
	And a staff with |	Apple	|	Brown	| 19970101 | Dvej 330 | 00000004 | France | ITC |
	When The clerk registers the staff
	Then the registration succeeds
	And the staff is registered
	
	
# Alternative scenarios
Scenario: The clerk registers a staff that already exists 
	Given the clerk is logged in
	And a staff with |	Eunjin	|	Yoo	|	19900101	|	Avej 330	|	00000001	|	Korea	|	doctor	|
	When The clerk registers the staff
	Then the registration fails
	And the user get error message "Staff already exists"
	And staff is not registered