Lookup a definition
Narrative:
In order to talk better
As an English student
I want to look up word definitions

Scenario: I can see the all inventory
Given I have an endpoint /store/inventory
When I perform a GET request to endpoint
Then I verify that status code is '200'
Then I check that Inventory response body contains value 200


Scenario: I can create new order
Given I have an endpoint /store/order
When I perform a POST request to endpoint
Then I verify that status code is '200'
Then I check that NewOrder response body contains value placed


Scenario: I can see the particular order by orderID
Given I have an endpoint /store/order/2
When I perform a GET request to endpoint
Then I verify that status code is '200'


Scenario: I can delete the particular order by orderID
Given I have an endpoint /store/order/2
When I perform a DELETE request to inventory endpoint
Then I verify that status code is '200'
