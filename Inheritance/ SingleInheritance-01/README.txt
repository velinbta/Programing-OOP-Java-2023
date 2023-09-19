1. Single Inheritance
Create two classes named Animal and Dog.

Animal with a single public method eat() that prints: "eating..."
Dog with a single public method bark() that prints: "barking..."
The Dog should inherit from the Animal.

You should be able to use your class like this:

public static void main(String[] args) {

    Dog dog = new Dog();

    dog.eat();
    dog.bark();

}

Output:
eating...
barking...