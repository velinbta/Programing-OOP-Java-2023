package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
    }

    @Override
    public void reserve(int numberOfPeople) {

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }

        this.isReserved = true;

        this.setPrice(this.calculateBoothPrice(numberOfPeople));

    }

    @Override
    public void orderDelicacy(Delicacy food) {
        this.delicacyOrders.add(food);
    }

    @Override
    public void orderCocktail(Cocktail cocktail) {
        this.cocktailOrders.add(cocktail);
    }

    @Override
    public double getBill() {
        return this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum() +
                this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
    }

    @Override
    public void clear() {

        this.isReserved = false;
        this.cocktailOrders.clear();
        this.delicacyOrders.clear();
        this.setPrice(0D);

    }

    private double calculateBoothPrice(int numberOfPeople) {
        return numberOfPeople * this.pricePerPerson;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

}
