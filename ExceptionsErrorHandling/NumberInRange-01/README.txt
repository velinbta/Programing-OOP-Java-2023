1. Number in Range 
Write a program to enter an integer in a certain range.
Until the number is not valid, enter a new number from the console. When the number is valid - end the program.

Input 
Read a range - two numbers, separated by a space.
On the next line, read the String.

Output 
Print the range in the following format: "Range: [{startIndex}...{endIndex}]".
When an invalid number is entered, String or the number is out of range, print "Invalid number: {num}".
When the entered number is valid, print "Valid number: {num}".

Examples:

Input 1:
10 20
5
xx
20

Output 1:
Range: [10...20]
Invalid number: 5
Invalid number: xx
Valid number: 20

Input 2:
-5 50
hi
-6
-1 

Output 2:
Range: [-5...50]
Invalid number: hi
Invalid number: -6
Valid number: -1