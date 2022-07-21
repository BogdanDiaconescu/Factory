# Factory

We have to create the entire stack for a factory that produces multiple types of cars

We have to manage:
- stock
- manufacturing
- sales

A client has to be able to come to the sales office, configure the car that he wants, get a quote and find out if the care can be made.

## Stock
- based on a defined initial quantity of steel manage parts creation
- generate additional steel for further parts
- keep track of steel reserves
- keep track of stock parts
- generate parts when needed by the factory
- answer stock queries
- generate part and pass it to the factory when requested remove part from actual stock
- offer possible parts
- offer estimated time when all parts can be done

## Factory
- create mechanism of creating cars
- answer sales queries if car can be made
- offer car types and models
- offer possible options for car 
- query stock before car creation

## Sales
- create customer interface for choosing car
- create customer interface for customizing car
- get from factory possible configurations
- get from factory price
- add margin depending on car brand
- offer price to customer
- keep record of previous transactions
- keep record of ongoing transactions
- keep record of waiting list
- in case we have a waiting list prioritize profit