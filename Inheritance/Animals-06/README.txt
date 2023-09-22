6. Animals 
Create a hierarchy of animals. Your program should have three different animals - Dog, Frog, and Cat.
Deeper in the hierarchy you should have two additional classes - Kitten and Tomcat.
Kittens are "Female" and Tomcats are "Male".
All types of animals should be able to produce some kind of sound - String produceSound().
For example, the dog should be able to bark.
Your task is to model the hierarchy and test its functionality.
Create an animal of each kind and make them all produce sound and create getters for all fields.
You will be given some lines of input. Every two lines will represent an animal.
On the first line will be the type of animal and on the second - the name, the age, and the gender.
When the command "Beast!" is given, stop the input and print all the animals in the format shown below.

Output 
Print the information for each animal in three lines. On the first line, print: "{animalType}".
On the second line, print: "{name} {age} {gender}".
On the third line, print the sounds it produces: "{produceSound()}".

Constraints 
Each Animal should have a name, an age, and a gender.
All input values should not be blank (e.g. name, age, and so on...).
If you receive an input for the gender of a Tomcat or a Kitten, ignore it but create the animal.
If the input is invalid for one of the properties, throw an exception with the message: "Invalid input!".
Each animal should have the functionality to produceSound().
Here is the type of sound each animal should produce:
Dog: "Woof!"
Cat: "Meow meow"
Frog: "Ribbit"
Kittens: "Meow"
Tomcat: "MEOW"

Examples:

Input 1:
Cat
Tom 12 Male
Dog
Rex 132 Male
Beast!

Output 1:
Cat 
Tom 12 Male
Meow meow
Dog 
Rex 132 Male
Woof!

Input 2:
Frog
Kermit 12 Male
Beast!

Output 2:
Frog 
Kermit 12 Male
Ribbit

Input 3:
Frog
Froakie -2 Male
Frog
Froakie 2 Male
Beast!

Output 3:
Invalid input!
Frog
Froakie 2 Male
Ribbit