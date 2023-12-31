package Calculator_04_1;

import java.util.ArrayList;
import java.util.List;

public class DivisionOperation implements Operation {

    private final List<Integer> operands;
    private int result;

    public DivisionOperation() {
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {

        validateOperand(operand);

        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0) / this.operands.get(1);
        }

    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 2;
    }

    private void validateOperand(int operand) {
        if (this.operands.size() == 1 && operand == 0)
            throw new ArithmeticException("Can't divide by zero");
    }

}
