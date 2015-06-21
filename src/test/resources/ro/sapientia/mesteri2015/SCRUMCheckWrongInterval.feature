Feature: Check if the interval entry works
	As Sapientia scrum tool user I want to be able to add from and to dates to the story

   Scenario: Give right dates
   Given I add a new sprint
   When I enter "2015-06-01 07:35" in  the from date datebox and I push the add button
   Then I should get result entry "2015-06-01 07:35" in new sprints list
