package Calculator_04_1;

public class CalculationEngine {

    private int result;
    private Operation currentOperation;

    public CalculationEngine() {
        this.result = 0;
        this.currentOperation = null;
    }

    public void pushNumber(int number) {

        if (this.currentOperation != null) {

            this.currentOperation.addOperand(number);

            if (this.currentOperation.isCompleted()) {
                this.result = currentOperation.getResult();
                this.currentOperation = null;
            }

        } else {

            this.result = number;

        }

    }

    public void pushOperation(Operation operation) {

        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }

    }

    public int getCurrentResult() {
        return this.result;
    }

}
