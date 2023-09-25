package SayHello_03_1;

public class Chinese implements Person {

    private final String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override // Changed to "Ni Hao!" was "Djydjybydjy"
    public String sayHello() {
        return "Ni Hao!";
    }

}
