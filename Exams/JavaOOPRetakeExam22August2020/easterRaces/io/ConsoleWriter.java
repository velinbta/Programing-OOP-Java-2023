package easterRaces.io;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }

}
