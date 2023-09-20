package StackOfStrings_04_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Custom Composition - Iterable Stack
public class StackOfStrings implements Iterable<String> {

    private final List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(0, item);
    }

    public String pop() {
        if (this.isEmpty())
            throw new NoSuchElementException("Stack is empty");

        String item = this.data.get(0);
        this.data.remove(item);

        return item;
    }

    public String peek() {
        return this.isEmpty()
                ? null : this.data.get(0);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public Iterator<String> iterator() {
        return this.data.iterator();
    }

}
