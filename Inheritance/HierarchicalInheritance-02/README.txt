2. Hierarchical Inheritance 
Create three classes named Animal, Dog, and Cat.

Animal with a single public method eat() that prints: "eating..."
Dog with a single public method bark() that prints: "barking..."
Cat with a single public method meow() that prints: "meowing..."
Dog and Cat should inherit from Animal.

You should be able to use your class like this:

public static void main(String[] args) {

    Dog dog = new Dog();
    dog.eat();
    dog.bark();

    Cat cat = new Cat();
    cat.eat();
    cat.meow();

}

Output:
eating...
barking...
eating...
meowing...
