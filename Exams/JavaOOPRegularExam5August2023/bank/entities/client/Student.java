package bank.entities.client;

public class Student extends BaseClient {

    private static final int INITIAL_INTEREST_RATE = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST_RATE, income);
    }

    @Override
    public void increase() {
        this.setInterest(this.getInterest() + 1);
    }

}
