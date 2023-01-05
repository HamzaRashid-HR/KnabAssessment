Feature: UpdateCard
	
@smoke
Scenario: Update card details on trello board
 	Given Card is on the board
 	When User clicks on ‘Edit’ option
 	Then Card detail dialogue appears
	When Update the description, title, member etc
	And Click ‘Save’ button
	Then Updated card displays on board