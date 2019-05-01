## Eunjin Yoo 
#Feature: Remove staff
#	Description: The clerk removes a staff from the database
#	Actor: clerk
#
#Background: The staff database has a set of staff
#	Given these staffs are contained in the staff database
#		|1	|	Eunjin	|	Yoo		|	19900101	|	Avej 330	|	00000001	|	Korea		|	doctor	|
#		|2	|	Kilian	|	Speiser	|	19900101	|	Bvej 330	|	00000002	|	Germany		|	nurse	|
#		|3	|	Kilian	|	Smith	|	19881212	|	Cvej 330	|	00000003	|	Denmark		|	ITC		|
#		|4	|	Taylor	|	Gregory	|	19970101	|	Cvej 330	|	00000004	|	Australia	|	clerk	|
#
## Main scenario
#Scenario: The clerk removes a staff 
#	Given the clerk is logged in
#	And a staff "Eunjin Yoo"
#	When the clerk deletes the staff
#	Then the removal succeeds
#	And the staff is removed
#	
#	
## Alternative scenarios
##Scenario: The clerk removes a staff that does not exist 
##	Given the clerk is logged in
##	And a staff is not found
##	When The clerk removes the staff
##	Then the removal fails
#
#
#Scenario: The clerk removes oneself
#	Given the clerk is logged in
#	And a staff with "Taylor Gregory"
#	When The clerk removes the staff
#	Then the removal fails
#	And the clerk gets error message "You cannot remove yourself"