2. Animal Farm 
You should be familiar with encapsulation already.
For this problem, you'll need to create a class called Chicken.
Chicken should contain several fields, a constructor, and several methods.
Your task is to encapsulate or hide anything that is not intended to be viewed or modified from outside the class.

Chicken lives for 15 years. Chicken has a name for sure, at least 1 symbol long.
Chicken producing eggs:
First 6 years it produces 2 eggs per day [0 - 5].
Next 6 years it produces 1 egg per day [6 - 11].
And after that, it produces 0.75 eggs per day.

Chicken 
- name: String
- age: int
+ Chicken(String, int)
- setName(String) : void
- setAge (int): void
+ productPerDay (): double
+ toString(): Override
- calculateProductPerDay() : double


Step 1. Encapsulate Fields
Fields should be private. Leaving fields open for modification from outside the class is potentially dangerous.
Make all fields in the Chicken class private.
In case the value inside a field is needed elsewhere, use getters to reveal it.

Step 2. Ensure Classes Have a Correct State 
Having getters and setters is useless if you don't use them.
The Chicken constructor modifies the fields directly which is wrong when there are suitable setters available.
Modify the constructor to fix this issue.

Step 3. Validate Data Properly 
Validate the chicken's name (it cannot be null, empty, or whitespace).
In case of an invalid name, print the exception message "Name cannot be empty."
Validate the age properly, minimum and maximum age are provided, make use of them.
In case of invalid age, print the exception message "Age should be between 0 and 15."

Step 4. Hide Internal Logic
If a method is intended to be used only by descendant classes or internally to perform some action, there is no point in keeping them public.
The calculateProductPerDay() method is used by the productPerDay() public method.
This means the method can safely be hidden inside the Chicken class by declaring it private.

Step 4. Submit Code to Judge
Submit your code as a zip file in Judge. Make sure you have a public Main class with a public static void main method in it.

Examples:

Input 1:
Chichi
10

Output 1:
Chicken Chichi (age 10) can produce 1.00 eggs per day.

Input 2:
Chichi
17

Output 2:
Age should be between 0 and 15.

Input 3:
Choko
6

Output 3:
Chicken Choko (age 6) can produce 1.00 eggs per day.