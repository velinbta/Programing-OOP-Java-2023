package Animals_03_1;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.toString() + System.lineSeparator() + "MEEOW";
    }

}
