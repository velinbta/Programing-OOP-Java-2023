package Calculator_04_1;

// main memory lives here and both MemorySaveOperation and MemoryRecallOperation gets it from here
public class InputInterpreter {

    private final CalculationEngine engine;
    private final Memory memory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memory = new Memory();
    }

    public void interpret(String input) {

        try {
            this.engine.pushNumber(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            this.engine.pushOperation(this.getOperation(input));
        }

    }

    public Operation getOperation(String operation) {

        switch (operation) {
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisionOperation();
            case "ms":
                return new MemorySaveOperation(this.memory);
            case "mr":
                return new MemoryRecallOperation(this.memory);
            default:
                throw new UnsupportedOperationException("This calculator doesn't support " + operation);
        }

    }

}
