package bank.entities.loan;

public class StudentLoan extends BaseLoan {

    private static final int AMOUNT = 10000;
    private static final int INTEREST_RATE = 1;

    public StudentLoan() {
        super(INTEREST_RATE, AMOUNT);
    }

}
