3. Birthday Celebrations
It is a well-known fact that people celebrate birthdays, it is also known that some people also celebrate their pet's birthdays.
Create class Citizen, Pet and Robot.
Pet has name and birthdate. Robot has id and model. Encompass repeated functionality into interfaces and implement them in your classes.

<<Interface>> 
Identifiable 
+ getId(): String

<<Interface>> 
Birthable 
+ getBirthDate(): String

Citizen
- name: String
- age: int
- id: String
- birthDate: String 
+ Citizen(String, int, String, String)
+ getName(): String
+ getAge(): int
+ getId(): String

Robot
(Exchanging fields of the robot or probably any class fields, leads to points loss in OJS)
- id: String
- model: String
+ Robot(String, String)
+ getId(): String
+ getModel(): String

Pet 
- name: String
- birthDate: String
+ Pet(String, String)
+ getName(): String
+ getBirthDate(): String

You will receive from the console an unknown amount of lines until the command "End" is received.
Each line will contain information in one of the following format:
"Citizen {name} {age} {id} {birthdate}" for citizens,  "Robot {model} {id}" for robots or "Pet {name} {birthdate}" for pets.
After the end command on the next line, you will receive a single number representing a specific year.
Your task is to print all birthdates (of both citizens and pets) in that year in the format:
"{day}/{month}/{year}" (the order of printing doesn't matter).

Examples:

Input 1:
Citizen Peter 22 9010101122 10/10/1990
Pet Sharo 13/11/2005
Robot MK-13 558833251
End
1990

Output 1:
10/10/1990

Input 2:
Citizen Stamo 16 0041018380 01/01/2000
Robot MK-10 12345678
Robot PP-09 00000001
Pet Topcho 24/12/2000
Pet Kosmat 12/06/2002 
End
2000

Output 2:
01/01/2000
24/12/2000

Input 3:
Robot VV-XYZ 11213141
Citizen Penk 35 7903210713 21/03/1979
Citizen Kane 40 7409073566 07/09/1974
End
1975

Output 3:
<no output>