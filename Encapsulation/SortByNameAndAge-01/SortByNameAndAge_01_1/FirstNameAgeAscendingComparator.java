package SortByNameAndAge_01_1;

import java.util.Comparator;

public class FirstNameAgeAscendingComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        // Първо име, възраст
        int result = first.getFirstName().compareTo(second.getFirstName());

        if (result == 0) return Integer.compare(first.getAge(), second.getAge());

        return result;
    }

}
