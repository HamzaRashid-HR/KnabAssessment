Feature: DeleteCard

@smoke
Scenario: Delete card on trello board

	Given User is logged in with project board
	Given Card is on the board
	When User clicks on Edit option
	Then Card detail dialogue appears
	When Click Archive
	When Press Delete button
	Then Card is deleted from the board