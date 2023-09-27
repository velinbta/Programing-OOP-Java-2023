package Telephony_05_1;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {

    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = new ArrayList<>(numbers);
        this.urls = new ArrayList<>(urls);
    }

    @Override
    public String call() {
        // digits only
        StringBuilder call = new StringBuilder();

        this.numbers.forEach(number -> {
            String info = number.matches("\\d+")
                    ? String.format("Calling... %s", number)
                    : invalidMessage("number");

            call.append(info);
            call.append(System.lineSeparator());
        });

        return call.toString().trim();
    }

    @Override
    public String browse() {
        // anything but digits
        StringBuilder browse = new StringBuilder();

        this.urls.forEach(url -> {
            String info = url.matches("\\D+")
                    ? String.format("Browsing: %s!", url)
                    : invalidMessage("URL");

            browse.append(info);
            browse.append(System.lineSeparator());
        });

        return browse.toString().trim();
    }

    private String invalidMessage(String function) {
        return String.format("Invalid %s!", function);
    }

}
