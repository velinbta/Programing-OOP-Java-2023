package goldDigger;

import goldDigger.core.Controller;
import goldDigger.core.ControllerImpl;
import goldDigger.core.Engine;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new Engine(controller);

        engine.run();

    }

}
