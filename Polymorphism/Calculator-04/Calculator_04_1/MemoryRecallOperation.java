package Calculator_04_1;

public class MemoryRecallOperation implements Operation {

    // memory dependency
    private final Memory memory;

    public MemoryRecallOperation(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        // ignored
    }

    @Override
    public int getResult() {
        return memory.recall();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

}
