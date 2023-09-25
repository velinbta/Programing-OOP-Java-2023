6. Ferrari
Model an application that contains a class Ferrari and an interface.
Your task is simple, you have a car - Ferrari, its model is "488-Spider" and it has a driver.
Your Ferrari should have the functionality to use brakes and push the gas pedal.
When the brakes are pushed down print "Brakes!", and when the gas pedal is pushed down - "brum-brum-brum-brrrrr".

As you may have guessed this functionality is typical for all cars, so you should implement an interface to describe it. 
Your task is to create a Ferrari and set the driver's name to the passed one in the input. After that, print the info.

<<Car>> 
+ brakes() : String
+ gas() : String

Ferrari
<- Car
- driverName: String
- model: String
+ Ferrari (String)
+ brakes() : String
+ gas() : String
+ toString(): String

Input 
On the single input line, you will be given the driver's name.

Output 
On the single output line, print the model, the messages from the brakes and gas pedal methods, and the driver's name.
In the following format: "{model}/{brakes}/{gas}/{driver's name}"

Constraints 
The input will always be valid, no need to check it explicitly! The Driver's name may contain any ASCII characters.

Take a look at the Examples to understand the task better.

Examples:

Input 1:
Dominic Toretto

Output 1:
488-Spider/Brakes!/brum-brum-brum-brrrrr/Dominic Toretto

Input 2:
Brian O'Conner

Output 2:
488-Spider/Brakes!/brum-brum-brum-brrrrr/Brian O'Conner