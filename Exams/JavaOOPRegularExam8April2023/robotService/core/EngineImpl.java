package robotService.core;

import robotService.common.Command;

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

                if (result.equals(Command.END.name())) {
                    break;
                }

            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
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
            case ADD_SERVICE:
                result = addService(data);
                break;
            case ADD_SUPPLEMENT:
                result = addSupplement(data);
                break;
            case SUPPLEMENT_FOR_SERVICE:
                result = supplementForService(data);
                break;
            case ADD_ROBOT:
                result = addRobot(data);
                break;
            case FEEDING_ROBOT:
                result = feedingRobot(data);
                break;
            case SUM_OF_ALL:
                result = sumOfAll(data);
                break;
            case STATISTICS:
                result = getStatistics();
                break;
            case END:
                result = Command.END.name();
                break;

        }
        return result;
    }

    private String addService(String[] data) {
        String type = data[0];
        String name = data[1];
        return this.controller.addService(type, name);
    }

    private String addSupplement(String[] data) {
        String type = data[0];
        return this.controller.addSupplement(type);
    }

    private String supplementForService(String[] data) {
        String serviceName = data[0];
        String supplementType = data[1];
        return this.controller.supplementForService(serviceName, supplementType);
    }

    private String addRobot(String[] data) {
        String serviceName = data[0];
        String robotType = data[1];
        String robotName = data[2];
        String robotKind = data[3];
        double price = Double.parseDouble(data[4]);
        return this.controller.addRobot(serviceName, robotType, robotName, robotKind, price);
    }

    private String feedingRobot(String[] data) {
        String serviceName = data[0];
        return this.controller.feedingRobot(serviceName);
    }

    private String sumOfAll(String[] data) {
        String serviceName = data[0];
        return this.controller.sumOfAll(serviceName);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }

}