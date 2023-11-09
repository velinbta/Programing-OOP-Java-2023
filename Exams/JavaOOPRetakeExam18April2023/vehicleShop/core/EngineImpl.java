package vehicleShop.core;

import vehicleShop.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class EngineImpl implements Engine {

    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        while (true) {

            String result;

            try {

                result = processInput();

                if (result.equals(Command.EXIT.name())) {
                    break;
                }

            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }

    }

    private String processInput() throws IOException {

        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.parseCommand(tokens[0]);

        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {

            case ADD_WORKER:
                result = addWorker(data);
                break;
            case ADD_VEHICLE:
                result = addVehicle(data);
                break;
            case ADD_TOOL_TO_WORKER:
                result = addToolToWorker(data);
                break;
            case MAKING_VEHICLE:
                result = makingVehicle(data);
                break;
            case STATISTICS:
                result = statistics();
                break;
            case EXIT:
                result = Command.EXIT.name();
                break;

        }
        return result;
    }

    private String addWorker(String[] data) {
        String workerType = data[0];
        String workerName = data[1];
        return this.controller.addWorker(workerType, workerName);
    }

    private String addVehicle(String[] data) {
        String vehicleName = data[0];
        int strengthRequired = Integer.parseInt(data[1]);
        return this.controller.addVehicle(vehicleName, strengthRequired);
    }

    private String addToolToWorker(String[] data) {
        String workerName = data[0];
        int power = Integer.parseInt(data[1]);
        return this.controller.addToolToWorker(workerName, power);
    }

    private String makingVehicle(String[] data) {
        String vehicleName = data[0];
        return this.controller.makingVehicle(vehicleName);
    }

    private String statistics() {
        return this.controller.statistics();
    }

}
