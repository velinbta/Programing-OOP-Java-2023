package Animals_03_1;

public abstract class Animal {

    private final String name;
    private final String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public abstract String explainSelf();

    @Override
    public String toString() {
        return String.format("I am %s and my favourite food is %s", this.name, this.favouriteFood);
    }

}
