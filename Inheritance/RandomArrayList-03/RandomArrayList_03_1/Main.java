package RandomArrayList_03_1;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> integerList = new RandomArrayList<>();
        IntStream.rangeClosed(1, 5000).forEach(integerList::add); // <- 1 - 5000

        System.out.println("Random list of Integer start size is " + integerList.size());

        // Wrong name in the task given - method also removes the element
        int randomIntegerElement = integerList.getRandomElement();
        System.out.println("Random Integer element is " + randomIntegerElement);
        System.out.println("Random list of Integer end size is " + integerList.size());

        System.out.println("=========================================");

        RandomArrayList<Character> alphabetList = new RandomArrayList<>();
        IntStream.rangeClosed('A', 'Z').forEach(ch -> alphabetList.add((char) ch)); // <- A - Z

        System.out.println("Random list of Character start size is " + alphabetList.size());

        char randomAlphabetElement = alphabetList.getRandomElement();
        System.out.println("Random Character element is " + randomAlphabetElement);
        System.out.println("Random list of Character end size is " + alphabetList.size());

    }

}
