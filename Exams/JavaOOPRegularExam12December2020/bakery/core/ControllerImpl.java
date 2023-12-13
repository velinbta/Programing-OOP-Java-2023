package bakery.core;

import bakery.common.ExceptionMessage;
import bakery.common.OutputMessage;
import bakery.entities.bakedFoods.BakedFood;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.drinks.Drink;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.Table;
import bakery.repositories.*;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncomeCompletedBills;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addFood(String type, String name, double price) {

        if (Objects.nonNull(this.foodRepository.getByName(name))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.FOOD_OR_DRINK_EXIST_FORMAT,
                    type, name));
        }

        BakedFood newFood = type.equals("Bread")
                ? new Bread(name, price)
                : new Cake(name, price);

        this.foodRepository.add(newFood);

        return String.format(OutputMessage.FOOD_ADDED_FORMAT, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {

        if (Objects.nonNull(this.drinkRepository.getByNameAndBrand(name, brand))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.FOOD_OR_DRINK_EXIST_FORMAT,
                    type, name));
        }

        Drink newDrink = type.equals("Tea")
                ? new Tea(name, portion, brand)
                : new Water(name, portion, brand);

        this.drinkRepository.add(newDrink);

        return String.format(OutputMessage.DRINK_ADDED_FORMAT, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        if (Objects.nonNull(this.tableRepository.getByNumber(tableNumber))) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.TABLE_EXIST_FORMAT,
                    tableNumber));
        }

        Table newTable = type.equals("InsideTable")
                ? new InsideTable(tableNumber, capacity)
                : new OutsideTable(tableNumber, capacity);

        this.tableRepository.add(newTable);

        return String.format(OutputMessage.TABLE_ADDED_FORMAT, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {

        Table suitableTable = this.tableRepository.getAll().stream().filter(table -> !table.isReserved() &&
                numberOfPeople <= table.getCapacity()).findFirst().orElse(null);

        if (Objects.isNull(suitableTable)) {
            return String.format(OutputMessage.RESERVATION_NOT_POSSIBLE_FORMAT, numberOfPeople);
        }

        suitableTable.reserve(numberOfPeople);

        return String.format(OutputMessage.TABLE_RESERVED_FORMAT, suitableTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {

        Table tableByNumber = this.tableRepository.getByNumber(tableNumber);

        if (Objects.isNull(tableByNumber) || !tableByNumber.isReserved()) {
            return String.format(OutputMessage.WRONG_TABLE_NUMBER_FORMAT, tableNumber);
        }

        BakedFood foodByName = this.foodRepository.getByName(foodName);

        if (Objects.isNull(foodByName)) {
            return String.format(OutputMessage.NONE_EXISTENT_FOOD_FORMAT, foodName);
        }

        tableByNumber.orderFood(foodByName);

        return String.format(OutputMessage.FOOD_ORDER_SUCCESSFUL_FORMAT, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {

        Table tableByNumber = this.tableRepository.getByNumber(tableNumber);

        if (Objects.isNull(tableByNumber) || !tableByNumber.isReserved()) {
            return String.format(OutputMessage.WRONG_TABLE_NUMBER_FORMAT, tableNumber);
        }

        Drink drinkByName = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);

        if (Objects.isNull(drinkByName)) {
            return String.format(OutputMessage.NON_EXISTENT_DRINK_FORMAT, drinkName, drinkBrand);
        }

        tableByNumber.orderDrink(drinkByName);

        return String.format(OutputMessage.DRINK_ORDER_SUCCESSFUL_FORMAT, tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {

        Table tableByNumber = this.tableRepository.getByNumber(tableNumber);

        double bill = tableByNumber.getBill();
        double price = tableByNumber.getPrice();

        double tableTotal = bill + price;
        this.totalIncomeCompletedBills += tableTotal;

        tableByNumber.clear();

        return String.format(OutputMessage.BILL_FORMAT, tableNumber, tableTotal);
    }

    @Override
    public String getFreeTablesInfo() {

        StringBuilder freeTablesInfo = new StringBuilder();

        this.tableRepository.getAll().stream().filter(table -> !table.isReserved()).
                forEach(table -> {
                    freeTablesInfo.append(table.getFreeTableInfo());
                    freeTablesInfo.append(System.lineSeparator());
                });

        return freeTablesInfo.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(OutputMessage.TOTAL_INCOME_FORMAT, this.totalIncomeCompletedBills);
    }

}
