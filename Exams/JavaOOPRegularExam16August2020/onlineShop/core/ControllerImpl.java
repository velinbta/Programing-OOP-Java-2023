package onlineShop.core;

import onlineShop.common.ExceptionMessage;
import onlineShop.common.OutputMessage;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computerById;
    private Map<Integer, Component> componentById;
    private Map<Integer, Peripheral> peripheralById;

    public ControllerImpl() {
        this.computerById = new HashMap<>();
        this.componentById = new HashMap<>();
        this.peripheralById = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {

        if (this.computerById.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessage.EXISTING_COMPUTER_ID);
        }

        Computer newComputer = this.getComputerByType(computerType, id, manufacturer, model, price);

        this.computerById.put(id, newComputer);

        return String.format(OutputMessage.ADDED_COMPUTER_FORMAT, id);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer,
                               String model, double price, double overallPerformance, int generation) {

        this.throwIfComputerWithGivenIdDoesNotExist(computerId);

        if (this.componentById.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessage.EXISTING_COMPONENT_ID);
        }

        Component newComponent = this.getComponentByType(componentType, id, manufacturer, model, price,
                overallPerformance, generation);

        Computer computerById = this.computerById.get(computerId);
        computerById.addComponent(newComponent);

        this.componentById.put(id, newComponent);

        return String.format(OutputMessage.ADDED_COMPONENT_FORMAT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        this.throwIfComputerWithGivenIdDoesNotExist(computerId);

        Computer computerById = this.computerById.get(computerId);

        Component removedComponent = computerById.removeComponent(componentType);
        this.componentById.remove(removedComponent.getId());

        return String.format(OutputMessage.REMOVED_COMPONENT_FORMAT, componentType, removedComponent.getId());
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {

        this.throwIfComputerWithGivenIdDoesNotExist(computerId);

        if (this.peripheralById.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessage.EXISTING_PERIPHERAL_ID);
        }

        Peripheral newPeripheral = this.getPeripheralByType(peripheralType, id, manufacturer,
                model, price, overallPerformance, connectionType);

        Computer computerById = this.computerById.get(computerId);
        computerById.addPeripheral(newPeripheral);

        this.peripheralById.put(id, newPeripheral);

        return String.format(OutputMessage.ADDED_PERIPHERAL_FORMAT, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {

        this.throwIfComputerWithGivenIdDoesNotExist(computerId);

        Computer computerById = this.computerById.get(computerId);

        Peripheral removedPeripheral = computerById.removePeripheral(peripheralType);
        this.peripheralById.remove(removedPeripheral.getId());

        return String.format(OutputMessage.REMOVED_PERIPHERAL_FORMAT, peripheralType, removedPeripheral.getId());
    }

    @Override
    public String buyComputer(int id) {

        this.throwIfComputerWithGivenIdDoesNotExist(id);

        Computer removedComputer = this.computerById.remove(id);

        return removedComputer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        Comparator<Computer> highestOverallPerformanceDescending = (firstComputer, secondComputer) -> {
            double firstComputerOverallPerformance = firstComputer.getOverallPerformance();
            double secondComputerOverallPerformance = secondComputer.getOverallPerformance();
            return Double.compare(secondComputerOverallPerformance, firstComputerOverallPerformance);
        };

        List<Computer> budgetSortedByOverallPerformance = this.computerById.values().stream().
                filter(computer -> computer.getPrice() <= budget).
                sorted(highestOverallPerformanceDescending).collect(Collectors.toList());

        if (budgetSortedByOverallPerformance.isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.CAN_NOT_BUY_COMPUTER_FORMAT,
                    budget));
        }

        Computer bestComputer = budgetSortedByOverallPerformance.get(0);
        this.computerById.remove(bestComputer.getId());

        return bestComputer.toString();
    }

    @Override
    public String getComputerData(int id) {

        this.throwIfComputerWithGivenIdDoesNotExist(id);

        return this.computerById.get(id).toString();
    }

    private void throwIfComputerWithGivenIdDoesNotExist(int computerId) {
        if (!this.computerById.containsKey(computerId)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXISTING_COMPUTER_ID);
        }
    }

    private Computer getComputerByType(String computerType, int id, String manufacturer, String model, double price) {

        switch (computerType) {

            case "DesktopComputer":
                return new DesktopComputer(id, manufacturer, model, price);
            case "Laptop":
                return new Laptop(id, manufacturer, model, price);
            default:
                throw new IllegalArgumentException(ExceptionMessage.INVALID_COMPUTER_TYPE);
        }

    }

    private Component getComponentByType(String componentType, int id, String manufacturer, String model,
                                         double price, double overallPerformance, int generation) {

        switch (componentType) {

            case "CentralProcessingUnit":
                return new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
            case "Motherboard":
                return new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
            case "PowerSupply":
                return new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
            case "RandomAccessMemory":
                return new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
            case "SolidStateDrive":
                return new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
            case "VideoCard":
                return new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
            default:
                throw new IllegalArgumentException(ExceptionMessage.INVALID_COMPONENT_TYPE);
        }

    }

    private Peripheral getPeripheralByType(String peripheralType, int id, String manufacturer, String model,
                                           double price, double overallPerformance, String connectionType) {

        switch (peripheralType) {

            case "Headset":
                return new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
            case "Keyboard":
                return new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
            case "Monitor":
                return new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
            case "Mouse":
                return new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
            default:
                throw new IllegalArgumentException(ExceptionMessage.INVALID_PERIPHERAL_TYPE);
        }

    }

}
