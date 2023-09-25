package BorderControl_05_1;

public class Robot implements Identifiable {

    private final String model;
    private final String id;

    public Robot(String model, String id) {
        this.id = id;
        this.model = model;
    }

    public static Robot parseRobot(String[] data) {
        // Static parse method
        String model = data[0];
        String id = data[1];

        return new Robot(model, id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

}
