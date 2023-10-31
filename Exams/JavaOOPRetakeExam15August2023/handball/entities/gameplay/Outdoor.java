package handball.entities.gameplay;

public class Outdoor extends BaseGameplay {

    private static final int DEFAULT_OUTDOOR_CAPACITY = 150;

    public Outdoor(String name) {
        super(name, DEFAULT_OUTDOOR_CAPACITY);
    }

}
