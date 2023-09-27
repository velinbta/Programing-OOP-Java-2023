4. Food Shortage
Your totalitarian dystopian society suffers a shortage of food, so many rebels appear.
Define a class Citizen(see the example below).
Define a class Rebel which has a name, age, and group (String).
Names are unique - there will never be 2 Rebels/Citizens or a Rebel and Citizen with the same name.
Define an interface Buyer which defines the methods buyFood() and a getFood().
Implement the Buyer interface in the Citizen and Rebel class.
Both Rebels and Citizens start with 0 food, when a Rebel buys food his food increases by 5.
When a Citizen buys food his food increases by 10.
 
On the first line of the input you will receive an integer N - the number of people.
On each of the next N lines you will receive information in one of the following formats:
"{name} {age} {id} {birthdate}" for a Citizen or  "{name} {age}{group}" for a Rebel.
After the N lines, until the command "End" is received, you will receive names of people who bought food, each on a new line.
Note that not all names may be valid, in the case of an incorrect name - nothing should happen.

On the only line of output, you should print the total amount of food purchased.

<<Interface>> 
Buyer 
+ buyFood(): void
+ getFood(): int

<<Interface>> 
Identifiable 
+ getId(): String

<<Interface>> 
Person 
+ getName(): String
+ getAge(): int

Citizen 
- name: String
- age: int
- id: String
- birthDate: String
- food: int
+ Citizen(String, int, String, String)
+ getName(): String
+ getAge(): int
+ getId(): String
+ getFood(): int
+ buyFood(): void

Rebel 
- name: String
- age: int
- group: String
- food: int
+ Rebel(String, int, String)
+ getName(): String
+ getAge(): int
+ getGroup(): String
+ getFood(): int
+ buyFood(): void

Examples:

Input 1:
2
Peter 25 8904041303 04/04/1989
Stan 27 WildMonkeys
Peter
George
Peter
End

Output 1:
20

Input 2:
4
Stam 23 TheSwarm
Tony 44 7308185527 18/08/1973
Joro 31 Terrorists
Peny 27 881222212 22/12/1988
Jaguar
Joro
Jaguar
Joro
Stam
Peny
End

Output 2:
25