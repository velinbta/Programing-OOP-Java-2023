package bakery.io;

public class ConsoleWriter implements OutputWriter {

    public void writeLine(String text) {
        System.out.println(text);
    }

}
