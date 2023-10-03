2. Vehicles Extension

Write a program that models 2 vehicles (Car and Truck) and will be able to simulate driving and refueling them in the summer.
Car and truck both have fuel quantity, and fuel consumption in liters per km and can be driven given distance and refueled with given liters.
But in the summer both vehicles use the air conditioner and their fuel consumption per km is increased by 0.9 liters for the car and 1.6 liters for the truck.
Also, the truck has a tiny hole in its tank and when it gets refueled it gets only 95% of the given fuel.
The car has no problems when refueling and adds all given fuel to its tank.
If the vehicle cannot travel a given distance its fuel does not change. 

Add new vehicle - Bus. Now every vehicle has tank capacity and fuel quantity cannot fall (set) below 0.
If fuel quantity becomes less than 0 print on the console "Fuel must be a positive number". 
The vehicles cannot be filled with fuel more than their tank capacity.
If you try to put more fuel in the tank than the available space, print on the console "Cannot fit fuel in tank" and do not add any fuel to the vehicle's tank. 
Add new command for the bus. The bus can drive with or without people.
If the bus is driving with people, the air-conditioner is turned on and its fuel consumption per kilometer is increased by 1.4 liters.
If there are no people on the bus when driving the air-conditioner is turned off and does not increase the fuel consumption.

Input 
On the first three lines you will receive information about the vehicles in the format:
Vehicle {initial fuel quantity} {liters per km} {tank capacity}
On the fourth line - a number of commands N will be given on the next N lines.
On the next N lines - commands in format:
Drive Car {distance}
Drive Truck {distance}
Drive Bus {distance}
DriveEmpty Bus {distance}
Refuel Car {liters}
Refuel Truck {liters}
Refuel Bus {liters} 

Output 
After each Drive command print whether the Car/Truck was able to travel a given distance in format if it's successful:
"Car/Truck/Bus travelled {distance} km".
If the command is invalid - do nothing.
Or if it is not: "Car/Truck/Bus needs refueling".
If given fuel is ? 0 print: "Fuel must be a positive number".
If given fuel cannot fit in car or bus tank print: "Cannot fit fuel in tank".
Finally, print the remaining fuel for a car, truck and bus rounded 2 digits after a floating point in the format: 
"Car: {liters}
Truck: {liters} 
Bus: {liters}"

Examples:

Input 1:
Car 30 0.04 70
Truck 100 0.5 300
Bus 40 0.3 150
8
Refuel Car -10
Refuel Truck 0
Refuel Car 10
Refuel Car 300
Drive Bus 10
Refuel Bus 1000
DriveEmpty Bus 100
Refuel Truck 1000

Output 1:
Fuel must be a positive number
Fuel must be a positive number
Cannot fit fuel in tank
Bus travelled 10 km
Cannot fit fuel in tank
Bus needs refueling
Cannot fit fuel in tank
Car: 40.00
Truck: 100.00
Bus: 23.00

Input 2:
Car 30.4 0.4 12
Truck 99.34 0.9 64
Bus 50 1.6 150
6
Drive Car 50
Drive Car 245
Rafuel Bus 4
Refuel Truck 10.300
Drive Truck 56.2
Refuel Car 100

Output 2:
Car needs refueling
Car needs refueling
Cannot fit fuel in tank
Truck needs refueling
Cannot fit fuel in tank
Car: 30.40
Truck: 99.34
Bus: 50.00