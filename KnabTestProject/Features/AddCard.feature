Feature: AddCard

@smoke
Scenario: Add new card on trello board
	#steps
	Given User is logged in with project board
	When User clicks on Add card
	Then Title text box appears
	When Insert title of the card
	When Enter details of card
	Then New card displays on board