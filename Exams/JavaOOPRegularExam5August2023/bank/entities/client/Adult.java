package bank.entities.client;

public class Adult extends BaseClient {

    private static final int INITIAL_INTEREST_RATE = 4;

    public Adult(String name, String ID, double income) {
        super(name, ID,INITIAL_INTEREST_RATE, income);
    }

    @Override
    public void increase() {
        this.setInterest(this.getInterest() + 2);
    }

}
