2. Point in Rectangle 
Create a class Point and a class Rectangle. The Point should hold coordinates X and Y and the Rectangle should hold 2 Points - its bottom left and top right corners.
In the Rectangle class, you should implement a contains(Point point) method that returns true or false, based on whether the Point given as an attribute is inside or outside the Rectangle object.
Points on the side of a Square are considered inside.

Input 
On the first line read the coordinates of the bottom left and top right corner of the Rectangle in the format:
"{bottomLeftX} {bottomLeftY} {topRightX} {topRightY}".
On the second line, read an integer N and on the next N lines, read the coordinates of points.

Output
For each point, print out the result of the Contains() method.

Examples:

Input 1:
0 0 3 3
5
0 0
0 1
4 4
5 3
1 2

Output 1:
true
true
false
false
true

Input 2:
2 -3 12 3
4
8 -1
11 3
1 1
2 4

Output 2:
true
true
false
false

Input 3:
5 8 12 15
6
0 0
5 8
12 15
8 15
7 15
8 12

Output 3:
false
true
true
true
true
true