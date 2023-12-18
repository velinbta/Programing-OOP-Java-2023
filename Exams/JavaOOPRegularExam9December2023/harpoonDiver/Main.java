package harpoonDiver;

import harpoonDiver.core.Controller;
import harpoonDiver.core.ControllerImpl;
import harpoonDiver.core.Engine;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new Engine(controller);
        engine.run();

    }

}
