1. Math Operation 
Create a class MathOperation, which should have method add().
Method add() has to be invoked with two, three, or four Integers.

public static void main(String[] args) throws IOException {

    MathOperation math = new MathOperation();
    System.out.println(math.add(2, 2));
    System.out.println(math.add(3, 3, 3));
    System.out.println(math.add(4, 4, 4, 4));

}

Output:
4
9
16