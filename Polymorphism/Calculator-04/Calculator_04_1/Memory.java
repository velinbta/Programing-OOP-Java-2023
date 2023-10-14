package Calculator_04_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Memory {

    private final Deque<Integer> memory;

    public Memory() {
        this.memory = new ArrayDeque<>();
    }

    public void save(int operand) {
        this.memory.push(operand);
    }

    public int recall() {
        return this.memory.pop();
    }

}
