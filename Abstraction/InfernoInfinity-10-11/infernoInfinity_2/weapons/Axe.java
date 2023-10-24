package infernoInfinity_2.weapons;

public class Axe extends Weapon {

    public static final int MIN_START_DAMAGE = 5;
    public static final int MAX_START_DAMAGE = 10;
    public static final int TOTAL_AVAILABLE_SOCKETS = 4;

    public Axe(String name) {
        super(name, MIN_START_DAMAGE, MAX_START_DAMAGE, TOTAL_AVAILABLE_SOCKETS);
    }

}
