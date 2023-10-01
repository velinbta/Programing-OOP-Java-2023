package WildFarm_04_1;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private final String livingRegion;

    protected Mammal(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        // Two digits after the decimal separator
        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(),
                this.getName(), df.format(this.getWeight()), this.getLivingRegion(), this.getFoodEaten());
    }

}
