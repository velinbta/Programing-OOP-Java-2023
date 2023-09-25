package SayHelloExtend_04_1;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override // Changed to latin, was "Здравей"
    public String sayHello() {
        return "Zdravei!";
    }

}
