package Animals_06_1;

public class Tomcat extends Cat {

    private static final String DEFAULT_TOMCAT_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, DEFAULT_TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }

}
