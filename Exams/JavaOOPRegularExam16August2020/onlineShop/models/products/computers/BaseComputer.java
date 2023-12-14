package onlineShop.models.products.computers;

import onlineShop.common.ExceptionMessage;
import onlineShop.common.OutputMessage;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {

        double computerOverallPerformance = super.getOverallPerformance();

        if (this.components.isEmpty()) {
            return computerOverallPerformance;
        }

        double average = this.components.stream().mapToDouble(Component::getOverallPerformance).
                average().getAsDouble();

        return computerOverallPerformance + average;
    }

    @Override
    public double getPrice() {
        double computerPrice = super.getPrice();
        double allComponentPrice = this.components.stream().mapToDouble(Component::getPrice).sum();
        double allPeripheralPrice = this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();

        return computerPrice + allComponentPrice + allPeripheralPrice;
    }

    @Override
    public void addComponent(Component component) {

        if (this.components.contains(component)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.EXISTING_COMPONENT_FORMAT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), component.getId()));
        }

        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

        Component componentByType = this.components.stream().filter(component ->
                component.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);

        if (this.components.isEmpty() || Objects.isNull(componentByType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.NOT_EXISTING_COMPONENT_FORMAT,
                    componentType, this.getClass().getSimpleName(), this.getId())); // TODO ID ??
        }

        this.components.remove(componentByType);

        return componentByType;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

        if (this.peripherals.contains(peripheral)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.EXISTING_PERIPHERAL_FORMAT,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {

        Peripheral peripheralByType = this.peripherals.stream().filter(peripheral -> peripheral.getClass().
                getSimpleName().equals(peripheralType)).findFirst().orElse(null);

        if (this.peripherals.isEmpty() || Objects.isNull(peripheralByType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.NOT_EXISTING_PERIPHERAL_FORMAT,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }

        this.peripherals.remove(peripheralByType);

        return peripheralByType;
    }

    @Override
    public List<Component> getComponents() {
        return Collections.unmodifiableList(this.components);
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return Collections.unmodifiableList(this.peripherals);
    }

    @Override
    public String toString() {

        StringBuilder computerToString = new StringBuilder();

        computerToString.append(super.toString()).append(System.lineSeparator());
        computerToString.append(String.format(OutputMessage.COMPUTER_COMPONENTS_TO_STRING_FORMAT,
                this.components.size())).append(System.lineSeparator());

        this.components.forEach(component -> {
            computerToString.append("  ").append(component);
            computerToString.append(System.lineSeparator());
        });

        double averageOverallPeripheralPerformance = this.peripherals.stream().
                mapToDouble(Peripheral::getOverallPerformance).average().orElse(0D);

        computerToString.append(String.format(OutputMessage.COMPUTER_PERIPHERALS_TO_STRING_FORMAT,
                this.peripherals.size(), averageOverallPeripheralPerformance)).append(System.lineSeparator());

        this.peripherals.forEach(peripheral -> {
            computerToString.append("  ").append(peripheral);
            computerToString.append(System.lineSeparator());
        });

        return computerToString.toString().trim();
    }

}
