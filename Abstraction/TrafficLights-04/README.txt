4. Traffic Lights 
Implement a simple state machine in the form of a traffic light.
Every traffic light has three possible signals - red, green, and yellow.
Each traffic light can be updated, which changes the color of its signal (e.g. if it is currently red, it changes to green, if it is green it changes to yellow).
The order of signals is red -> green -> yellow -> red and so on.

On the first line, you will be given multiple traffic light signals in the format "RED GREEN YELLOW".
They may be 3, more, or less than 3. You need to make as many traffic lights as there are signals in the input. 
On the second line, you will receive the n number of times you need to change each traffic light's signal.
Your output should consist of n number of lines, including each updated traffic light's signal.
To better understand the problem, see the example below.

Examples:

Input 1:
GREEN RED YELLOW
4

Output 1:
YELLOW GREEN RED
RED YELLOW GREEN
GREEN RED YELLOW
YELLOW GREEN RED

Input 2:
RED RED RED GREEN GREEN GREEN
6
