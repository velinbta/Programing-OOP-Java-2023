package catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private static final int INITIAL_KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price, INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 3);
    }

}
