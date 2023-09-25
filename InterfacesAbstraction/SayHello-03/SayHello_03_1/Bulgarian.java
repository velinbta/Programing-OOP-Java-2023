package SayHello_03_1;

public class Bulgarian implements Person {

    private final String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override // Changed to latin, was "Здравей"
    public String sayHello() {
        return "Zdravei!";
    }

}
