package SayHello_03_1;

public interface Person {

    String getName();

    default String sayHello() {
        return "Hello!";
    }

}
