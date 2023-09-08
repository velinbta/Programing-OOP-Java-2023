5. Jedi Galaxy (refactor)
Peter is Jedi, and so he starts gathering stars to grow stronger.
His galaxy is represented as a two-dimensional array.
Every cell in the matrix is a star that has a value. Peter starts at the given col and row.
He can move only on the diagonal from the lowest left to the upper right and adds to his score  all the stars (values) from the cells he passes through.
Unfortunately, there is always an Evil power that tries to prevent his success.

Evil power starts at the given row and col and instantly destroys all-stars on the opposite diagonal - From the lowest right to the upper left.  
Peter adds the values only of the stars that are not destroyed by the evil power.

You will receive two integers, separated by space, which represent the two-dimensional array - the first being the
rows and the second being the columns. Then, you must fill the two-dimensional array with increasing integers
starting from 0, and continuing on every row, like this: 
first row: 0, 1, 2... m
second row: n+1, n+2, n+3... n + n.

Example:

			0   1   2   3   4
			5   6   7   8   9
			10  11  12  13  14
			15  16  17  18  19
 			20  21  22  23  24
Peter[5;-1] 					Evil[5;5]
 		
Peter is at row 5, col -1: Peter[5;-1]
Evil is on the opposite side Evil[5;5]


			0   1   2   3   4
			5   6   7   8   9
			10  11  12  13  14
			15  16  17  18  19
Peter[4;-1]		20  21  22  23  24     Evil[4;5]

Peter is at row 4, col -1: Peter[4;-1]
Evil is on the opposite side Evil[4;5]
     		  	
[So apparently both can start outside the matrix, or they can just start from inside depending on the coordinates] - Note

Peter starts with coordinates row = 5, col = -1. He must collect all stars with value [20, 16, 12, 8, 4].
Evil starts with coordinates row = 5, col = 5. Evil destroys all-stars in the range [24, 18, 12, 6, 0].
The star with a value of 12 is the cross point for Peter and The Evil, so Peter skips the stars and collects only those who are not in the evil range. 

You will also receive multiple pairs of commands in the form of 2 integers separated by a single space.
The first two integers will represent Peter's start coordinates.
The second one will represent the Evil Power's start coordinates.

Input 
On the first line, you will receive the number N, M -> the dimensions of the matrix. You must then fill the matrix according to these dimensions.
On the next several lines you will begin receiving 2 integers separated by a single space, which represent Peter's row and col. 
On the next line, you will receive the Evil Power's coordinates.
There will always be at least 2 lines of input to represent at least 1 path of Peter and the Evil force.
When you receive the command, "Let the Force be with you" the input ends.

Output 
The output is simple. Print the sum of the values from all-stars that Peter has collected.

Constraints 
The dimensions of the matrix will be integers in the range [5, 2000].
The given rows will be valid integers in the range [0, 2000].
The given columns will be valid integers in the range [-2 to the power of 31 + 1, 2 to the power of 31 - 1]  

Examples:

Input 1:
5 5
5 -1
5 5
Let the Force be with you

Output 1:
48

Input 2:
5 5
4 -1
4 5
Let the Force be with you

Output 2:
29