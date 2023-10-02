1. Vehicles 
Write a program that models 2 vehicles (Car and Truck).
It must be able to simulate driving and refueling. 
Car and truck both have fuel quantity, and fuel consumption in liters per km and can be driven given distance and refueled with given liters.
But in the summer both vehicles use the air conditioner and their fuel consumption per km is increased by 0.9 liters for the car and 1.6 liters for the truck.
Also, the truck has a tiny hole in its tank and when it gets refueled it gets only 95% of the given fuel.
The car has no problems when refueling and adds all given fuel to its tank.
If the vehicle cannot travel a given distance its fuel does not change.

Input
On the first line - information about the car in format "Car {fuel quantity} {liters per km}".
On the second line - info about the truck in the format "Truck {fuel quantity} {liters per km}".
On the third line - a number of commands N will be given on the next N lines.
On the next N lines - commands in the format:
Drive Car {distance}
Drive Truck {distance}
Refuel Car {liters}
Refuel Truck {liters}

Output 
After each Drive command print whether the Car/Truck was able to travel a given distance in format if it's successful.
Print the distance with two digits after the decimal separator except for trailing zeros.
Use the DecimalFormat class:
"Car/Truck travelled {distance} km"
Or if it is not:
"Car/Truck needs refueling"

Finally, print the remaining fuel for both car and truck rounded 2 digits after the floating point in the format:
"Car: {liters}
Truck: {liters}" 

Examples:

Input 1:
Car 15 0.3
Truck 100 0.9
4
Drive Car 9
Drive Car 30
Refuel Car 50
Drive Truck 10

Output 1:
Car travelled 9 km
Car needs refueling
Truck travelled 10 km
Car: 54.20
Truck: 75.00

Input 2:
Car 30.4 0.4
Truck 99.34 0.9
5
Drive Car 500
Drive Car 13.5
Refuel Truck 10.300
Drive Truck 56.2
Refuel Car 100.2

Output 2:
Car needs refueling
Car travelled 13.5 km
Truck needs refueling
Car: 113.05
Truck: 109.13