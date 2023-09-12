package GreedyTimes_06_2;

public class Gold extends Item { // <- Вид Item

    public long totalAmount;

    @Override
    public void add(String item, long amount) {
        this.totalAmount += amount;
    }

    @Override
    public long getTotalAmount() {
        return this.totalAmount;
    }

    @Override
    public String toString() {
        return String.format("##Gold - %d", this.getTotalAmount());
    }

}
