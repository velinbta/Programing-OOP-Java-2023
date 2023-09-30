package Animals_03_1;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.toString() + System.lineSeparator() + "DJAAF";
    }

}
