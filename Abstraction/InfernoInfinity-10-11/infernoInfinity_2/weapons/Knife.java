package infernoInfinity_2.weapons;

public class Knife extends Weapon {

    public static final int MIN_START_DAMAGE = 3;
    public static final int MAX_START_DAMAGE = 4;
    public static final int TOTAL_AVAILABLE_SOCKETS = 2;

    public Knife(String name) {
        super(name, MIN_START_DAMAGE, MAX_START_DAMAGE, TOTAL_AVAILABLE_SOCKETS);
    }

}
