package restaurant.core;

import restaurant.common.ExceptionMessage;
import restaurant.common.OutputMessage;
import restaurant.entity.drink.Fresh;
import restaurant.entity.drink.Smoothie;
import restaurant.entity.food.Salad;
import restaurant.entity.food.VeganBiscuits;
import restaurant.entity.food.HealthyFood;
import restaurant.entity.drink.Beverages;
import restaurant.entity.table.InGarden;
import restaurant.entity.table.Indoors;
import restaurant.entity.table.Table;
import restaurant.repository.BeverageRepository;
import restaurant.repository.HealthFoodRepository;
import restaurant.repository.TableRepository;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoneyAllClosedBills;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {

        HealthyFood newFood = type.equals("Salad")
                ? new Salad(name, price)
                : new VeganBiscuits(name, price);

        if (Objects.nonNull(this.healthFoodRepository.foodByName(name))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.FOOD_EXIST_FORMAT, name));
        }

        this.healthFoodRepository.add(newFood);

        return String.format(OutputMessage.FOOD_ADDED_FORMAT, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {

        Beverages newBeverage = type.equals("Smoothie")
                ? new Smoothie(name, counter, brand)
                : new Fresh(name, counter, brand);

        if (Objects.nonNull(this.beverageRepository.beverageByName(name, brand))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.BEVERAGE_EXIST_FORMAT, name));
        }

        this.beverageRepository.add(newBeverage);

        return String.format(OutputMessage.BEVERAGE_ADDED_FORMAT, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        Table newTable = type.equals("Indoors")
                ? new Indoors(tableNumber, capacity)
                : new InGarden(tableNumber, capacity);

        if (Objects.nonNull(this.tableRepository.byNumber(tableNumber))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.TABLE_IS_ALREADY_ADDED_FORMAT,
                    tableNumber));
        }

        this.tableRepository.add(newTable);

        return String.format(OutputMessage.TABLE_ADDED_FORMAT, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {

        Table suitableTable = this.tableRepository.getAllEntities().stream().
                filter(table -> !table.isReservedTable() && numberOfPeople <= table.getSize()).
                findFirst().orElse(null);

        if (Objects.isNull(suitableTable)) {
            return String.format(OutputMessage.RESERVATION_NOT_POSSIBLE_FORMAT, numberOfPeople);
        }

        suitableTable.reserve(numberOfPeople);

        return String.format(OutputMessage.TABLE_RESERVED_FORMAT, suitableTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {

        Table tableByNumber = this.tableRepository.byNumber(tableNumber);

        if (Objects.isNull(tableByNumber)) {
            return String.format(OutputMessage.WRONG_TABLE_NUMBER_FORMAT, tableNumber);
        }

        HealthyFood foodByName = this.healthFoodRepository.foodByName(healthyFoodName);

        if (Objects.isNull(foodByName)) {
            return String.format(OutputMessage.NONE_EXISTENT_FOOD_FORMAT, healthyFoodName);
        }

        tableByNumber.orderHealthy(foodByName);

        return String.format(OutputMessage.FOOD_ORDER_SUCCESSFUL_FORMAT, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {

        Table tableByNumber = this.tableRepository.byNumber(tableNumber);

        if (Objects.isNull(tableByNumber)) {
            return String.format(OutputMessage.WRONG_TABLE_NUMBER_FORMAT, tableNumber);
        }

        Beverages beverageByName = this.beverageRepository.beverageByName(name, brand);

        if (Objects.isNull(beverageByName)) {
            return String.format(OutputMessage.NON_EXISTENT_DRINK_FORMAT, name, brand);
        }

        tableByNumber.orderBeverages(beverageByName);

        return String.format(OutputMessage.BEVERAGE_ORDER_SUCCESSFUL_FORMAT, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {

        Table table = this.tableRepository.byNumber(tableNumber);

        double totalForTable = table.bill() + table.allPeople();
        this.totalMoneyAllClosedBills += totalForTable;

        table.clear();

        return String.format(OutputMessage.BILL_FORMAT, tableNumber, totalForTable);
    }

    @Override
    public String totalMoney() {
        return String.format(OutputMessage.TOTAL_MONEY_FORMAT, this.totalMoneyAllClosedBills);
    }

}
