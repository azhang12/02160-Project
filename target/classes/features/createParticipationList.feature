@CreateLists
Feature: Create lists
	As a clerk
	I want to create participation lists of health facility departments
	In order to verify patients in a department and get information of them
	
	Scenario: Create a list
	
		Actor: Clerk
		
		Given I am on the system with "clerk mode"
		When I click "Create"
		Then I should see "list" button
		And I should see the name list of departments
		Then I click the "health facility" button
		And I should see a pdf file of list