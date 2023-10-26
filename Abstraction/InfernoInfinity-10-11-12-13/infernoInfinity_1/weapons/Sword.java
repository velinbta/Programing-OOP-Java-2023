package infernoInfinity_1.weapons;

public class Sword extends Weapon {

    public static final int MIN_START_DAMAGE = 4;
    public static final int MAX_START_DAMAGE = 6;
    public static final int TOTAL_AVAILABLE_SOCKETS = 3;

    public Sword(String name) {
        super(name, MIN_START_DAMAGE, MAX_START_DAMAGE, TOTAL_AVAILABLE_SOCKETS);
    }

}
