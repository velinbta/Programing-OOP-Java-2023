3. Validation Data

Create a class Person, which should have private fields for:
firstName: String
lastName: String
age: int
toString() - override

Read person with their names, age, and salary. Read percent bonus to every person salary.
People younger than 30 get a half bonus.
Add salary field and getter and setter with proper access.
New fields and methods:
salary: double 
increaseSalary(double bonus)

Expand Person with proper validation for every field:
Names must be at least 3 symbols
Age must not be zero or negative
Salary can't be less than 460.0 
Print proper message to end-user (look at an example for messages).
Don't use System.out.println() in Person class.

Examples:

Input 1:
5
Asen Ivanov -6 2200
B Borisov 57 3333
Ventsislav Ivanov 27 600
Asen H 44 666.66
Boiko Angelov 35 300
20

Output 1:
Age cannot be zero or negative integer
First name cannot be less than 3 symbols
Last name cannot be less than 3 symbols
Salary cannot be less than 460 leva
Ventsislav Ivanov gets 660.0 leva

Input 2:
4
Sara Cameron 21 1200
John Petrovich -53 850.50
Anna Glen 21 430
John Alekseevich 0 2100
13

Output 2:
Age cannot be zero or negative integer
Salary cannot be less than 460 leva
Age cannot be zero or negative integer
Sara Cameron gets 1278.0 leva