package christmasPastryShop.io;

import christmasPastryShop.io.interfaces.OutputWriter;

@SuppressWarnings("FieldMayBeFinal")
public class ConsoleWriter implements OutputWriter {

    public void writeLine(String text) {
        System.out.println(text);
    }

}
