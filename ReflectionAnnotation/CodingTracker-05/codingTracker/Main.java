package codingTracker;

public class Main {

    @Author(name = "George")
    public static void main(String[] args) {

        Tracker.printMethodsByAuthor(Main.class);

        Tracker.printMethodsByAuthor(Tracker.class);

    }

}
