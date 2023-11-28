package restaurant.entity.table;

import restaurant.common.ExceptionMessage;
import restaurant.entity.drink.Beverages;
import restaurant.entity.food.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;

    private int number; // <- table number
    private int size; // <- table size
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople; // <- price for all people

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.setNumber(number);
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
    }

    @Override
    public void reserve(int numberOfPeople) {

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;

    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {

        double beverageBill = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
        double foodBill = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();

        return beverageBill + foodBill;
    }

    @Override
    public void clear() {

        this.beverages.clear();
        this.healthyFood.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        this.allPeople = 0;

    }

    @Override
    public double allPeople() {
        this.allPeople = this.numberOfPeople() * this.pricePerPerson();
        return this.allPeople;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    @SuppressWarnings("all")
    public String tableInformation() { // <- not included anywhere

        StringBuilder info = new StringBuilder();

        info.append(String.format("Table - %d", this.getTableNumber())).append(System.lineSeparator());
        info.append(String.format("Size - %d", this.getSize())).append(System.lineSeparator());
        info.append(String.format("Type - %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        info.append(String.format("All price - %.2f", this.pricePerPerson()));

        return info.toString().trim();
    }

}
