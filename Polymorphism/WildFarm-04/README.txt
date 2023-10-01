4. *Wild Farm 
Your task is to create a class hierarchy like the picture below.
All the classes except Vegetable, Meat, Mouse, Tiger, Cat & Zebra should be abstract.

Food
Integer quantity;

Vegetable
<- Food

Meat
<- Food

Animal
String animalName;
String animalType;
Double animalWeight;
Integer foodEaten;

void makeSound();
void eat(Food);

Mammal
<- Animal
String livingRegion;

Mouse
<- Mammal

Zebra
<- Mammal

Feline
<- Mammal

Cat
<- Feline
String breed;

Tiger
<- Feline
String livingRegion

Input should be read from the console. 
Every even line will contain information about the Animal in following format: 
"{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}".
If the animal is a cat: "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}".

On the odd lines, you will receive information about the food that you should give to the Animal.
The line will consist of FoodType and quantity separated by whitespace.

You should build the logic to determine if the animal is going to eat the provided food.
The Mouse and Zebra should check if the food is Vegetable.
If it is they will eat it. Otherwise, you should print a message in the format:
"{AnimalType} are not eating that type of food!". AnimalType to be in the plural.
Cats eat any kind of food, but Tigers accept only Meat.
If a Vegetable is provided to a tiger message like the one above should be printed on the console.
After you read information about the Animal and Food then invoke makeSound() method of the current animal and then feed it.
In the end, print the whole object in the format:
"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
If the animal is a cat: "{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
Proceed to read information about the next animal/food. The input will continue until you receive "End".
Print all AnimalWeight with two digits after the decimal separator. Use the DecimalFormat class.
Note: consider overriding toString() method. 

Examples:

Input 1:
Cat Gray 1.1 Home Persian
Vegetable 4
End

Output 1:
Meowwww
Cat[Gray, Persian, 1.1, Home, 4]

Input 2:
Tiger Tom 167.7 Asia
Vegetable 1
End

Output 2:
ROAAR!!!
Tigers are not eating that type of food!
Tiger[Tom, 167.7, Asia, 0]

Input 3:
Zebra Jaguar 500 Africa
Vegetable 150
End

Output 3:
Zs
Zebra[Jaguar, 500, Africa, 150]

Input 4:
Mouse Jerry 0.5 Anywhere
Vegetable 0
End

Input 4:
SQUEEEAAAK!
Mouse[Jerry, 0.5, Anywhere, 0]