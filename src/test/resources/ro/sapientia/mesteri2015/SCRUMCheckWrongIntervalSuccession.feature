Feature: Check if the date entry works if wrong dates are added
	As Sapientia scrum tool user I want not to be able to add wrong succession of start and end dates to the story

   Scenario: Give wrong succession of interval
   Given I add a new sprint with wrong dates successions
   When I enter "2015-06-20 07:35" in the from date datebox first 
     And enter "2015-06-02 07:35" I push the add button
   Then I should get sent to edit boxes because of wrong date succession
