package bakery.entities.tables;

import bakery.common.ExceptionMessage;
import bakery.entities.bakedFoods.BakedFood;
import bakery.entities.drinks.Drink;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseTable implements Table {

    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getPrice() {
        this.price = this.getNumberOfPeople() * this.getPricePerPerson();
        return this.price;
    }

    @Override
    public double getBill() {
        double orderedFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        double orderedDrinks = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();

        return orderedFood + orderedDrinks;
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.numberOfPeople = 0;
        this.price = 0D;
        this.isReserved = false;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    @SuppressWarnings("all")
    public String getFreeTableInfo() {

        StringBuilder tableInfo = new StringBuilder();

        tableInfo.append(String.format("Table: %d", this.getTableNumber())).
                append(System.lineSeparator());
        tableInfo.append(String.format("Type: %s", this.getClass().getSimpleName())).
                append(System.lineSeparator());
        tableInfo.append(String.format("Capacity: %d", this.getCapacity())).
                append(System.lineSeparator());
        tableInfo.append(String.format("Price per Person: %.2f", this.getPricePerPerson()));

        return tableInfo.toString().trim();
    }

}
