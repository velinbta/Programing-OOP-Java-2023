package RandomArrayList_03_1;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    // Wrong name in the task given - method also removes the element
    public T getRandomElement() {

        if (super.isEmpty()) throw new NoSuchElementException("List is empty");

        int randomIndex = ThreadLocalRandom.current().nextInt(0, super.size());

        T element = super.get(randomIndex);
        super.remove(element);

        return element;
    }

}
