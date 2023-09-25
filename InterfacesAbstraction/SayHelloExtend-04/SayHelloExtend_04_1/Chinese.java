package SayHelloExtend_04_1;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override // Changed to "Ni Hao!" was "Djydjybydjy"
    public String sayHello() {
        return "Ni Hao!";
    }

}
