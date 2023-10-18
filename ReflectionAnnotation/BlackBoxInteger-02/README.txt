2. Black Box Integer
Import "BlackBoxInt.java" in your project.
You are helping a buddy of yours who is still in the OOP Basics course - his name is John.
He is rather slow and made a class with all private members.

Your tasks are to instantiate an object from his class (always with start value 0) and then invoke the different methods it has.
Your restriction is to not change anything in the class itself (consider it a black box).
You can look at his class but don't touch anything! The class itself is called BlackBoxInt.
It is a wrapper for the int primitive.
The methods it has are:

private void add(int addend) { this.innerValue += addend; }

private void subtract(int subtrahend) { this.innerValue -= subtrahend; }

private void multiply(int multiplier) { this.innerValue *= multiplier; }

private void divide(int divider) { this.innerValue /= divider; }

private void leftShift(int shifter) { this.innerValue <<= shifter; }

private void rightShift(int shifter) { this.innerValue >>= shifter; }

Examples:

Input 1:
add_999999
subtract_19
divide_4
multiply_2
rightShift_1
leftShift_3
END

Output 1:
999999
999980
249995
499990
249995
1999960

Input 2:
subtract_3000
add_556677
add_889915
rightShift_3
leftShift_3
END

Output 2:
-3000
553677
1443592
180449
1443592