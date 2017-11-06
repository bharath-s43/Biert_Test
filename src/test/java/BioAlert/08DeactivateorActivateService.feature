Feature: Deactivate and Reactivate Service

Scenario: Deactivate service

Given go to cancel service page
Then click on Deactivate button
Then click on confirm


Scenario: Reactivate service

Given go to patients page
Then click on Reactivate button


Scenario: Make the payment
Given select the patient from patient dropdown
Then enter the card details
Then click on submit button1
