package Word_03_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class TextTransformer {

    private final StringBuilder text;
    private Deque<String> memory;

    public TextTransformer(String text) {
        this.text = new StringBuilder(text);
    }

    public String toUpperCase(int startIndex, int endIndex) {
        this.ensureIndexes(startIndex, endIndex);

        String upper = this.text.substring(startIndex, endIndex).toUpperCase();
        return text.replace(startIndex, endIndex, upper).toString();
    }

    public String cut(int startIndex, int endIndex) {
        this.lazyMemoryInit();
        this.ensureIndexes(startIndex, endIndex);

        this.memory.push(this.getText().substring(startIndex, endIndex));

        return this.text.delete(startIndex, endIndex).toString();
    }

    public String cut(int startIndex) {
        // cut from start to end of text
        this.lazyMemoryInit();
        this.ensureIndexes(startIndex, this.getTextLength());

        this.memory.push(this.getText().substring(startIndex, this.getTextLength()));

        return this.text.delete(startIndex, this.getTextLength()).toString();
    }

    public String paste(int startIndex, int endIndex) {
        // if nothing cut - return ""
        if (!this.ensureValidMemoryState())
            return "";

        this.ensureIndexes(startIndex, endIndex);

        this.text.replace(startIndex, endIndex, this.memory.peek());

        return this.getText();
    }

    public boolean removeLastCut() {
        if (!this.ensureValidMemoryState())
            return false;

        this.memory.pop();
        return true;
    }

    public boolean indexesAreBothValid(int startIndex, int endIndex) {
        return startIndex >= 0 && startIndex <= this.getTextLength() && startIndex <= endIndex;
    }

    private void ensureIndexes(int startIndex, int endIndex) { // <- inner indexes
        if (startIndex < 0)
            throw this.outOfBoundsException("Start index can't be negative");

        if (startIndex > this.getTextLength() || startIndex > endIndex)
            throw this.outOfBoundsException(String.format("Range [%d, %d) out of bounds for length %d",
                    startIndex, this.getTextLength(), this.getTextLength()));
    }

    public String getText() {
        return this.text.toString();
    }

    public int getTextLength() {
        return this.text.length();
    }

    public int cutTextMemorized() { // <- saved cut commands
        if (!this.ensureValidMemoryState())
            return 0;
        return this.memory.size();
    }

    private void lazyMemoryInit() { // <- lazy instantiation
        if (Objects.isNull(this.memory))
            this.memory = new ArrayDeque<>();
    }

    private boolean ensureValidMemoryState() {
        return Objects.nonNull(this.memory) && !this.memory.isEmpty();
    }

    private StringIndexOutOfBoundsException outOfBoundsException(String message) {
        throw new StringIndexOutOfBoundsException(message);
    }

    @Override
    public String toString() {
        return text.toString();
    }

}
