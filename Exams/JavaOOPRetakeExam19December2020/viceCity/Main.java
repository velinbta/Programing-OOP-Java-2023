package viceCity;

import viceCity.core.ControllerImpl;
import viceCity.core.Engine;
import viceCity.core.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new Engine(controller);
        engine.run();

    }

}
