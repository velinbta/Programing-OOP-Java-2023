package MathOperation_01_1;

// This class is not static because of the Open judge system requirement
// This class should contain only static methods, no instance needed, no state kept in this class
public class MathOperation {

    public int add(int first, int second) {
        return first + second;
    }

    public int add(int first, int second, int third) {
        return this.add(first, second) + third;
    }

    public int add(int first, int second, int third, int forth) {
        return this.add(first, second, third) + forth;
    }

}
