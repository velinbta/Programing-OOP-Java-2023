package bank.entities.loan;

public class MortgageLoan extends BaseLoan {

    private static final int AMOUNT = 50000;
    private static final int INTEREST_RATE = 3;

    public MortgageLoan() {
        super(INTEREST_RATE, AMOUNT);
    }

}
