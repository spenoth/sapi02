Feature: Check if the interval entry works
	As Sapientia scrum tool user I want not to be able to add wrong from and to dates to the sprint

   Scenario: Give wrong dates
   Given I add a new sprint with wrong interval
   When I enter "2015-50 07:35" in  the from date date box after I push the add button
   Then I should get sent to edit boxes