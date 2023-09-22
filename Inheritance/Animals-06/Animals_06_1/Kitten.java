package Animals_06_1;

public class Kitten extends Cat {

    private static final String DEFAULT_KITTENS_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, DEFAULT_KITTENS_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }

}
