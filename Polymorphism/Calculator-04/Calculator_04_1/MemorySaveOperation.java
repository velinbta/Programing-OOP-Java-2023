package Calculator_04_1;

public class MemorySaveOperation implements Operation {

    private int lastSaved;
    private boolean completed;
    // memory dependency
    private final Memory memory;

    public MemorySaveOperation(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.save(operand);
        this.lastSaved = operand;
        this.completed = true;
    }

    @Override
    public int getResult() {
        return this.lastSaved;
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

}
