package glacialExpedition;

import glacialExpedition.core.Controller;
import glacialExpedition.core.ControllerImpl;
import glacialExpedition.core.Engine;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();

        Engine engine = new Engine(controller);
        engine.run();

    }

}
