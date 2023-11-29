package spaceStation;

import spaceStation.core.Controller;
import spaceStation.core.ControllerImpl;
import spaceStation.core.Engine;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();

        Engine engine = new Engine(controller);
        engine.run();

    }

}
