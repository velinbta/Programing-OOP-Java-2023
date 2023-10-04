package Word_03_1;

import java.util.Scanner;

public class Main {

    public static final String END_COMMAND = "exit";
    public static final String UPPERCASE_COMMAND = "uppercase";
    public static final String CUT_COMMAND = "cut";
    public static final String PASTE_COMMAND = "paste";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TextTransformer transformer = new TextTransformer(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND)) {

            String[] data = input.split("\\s+");

            String command = data[0];
            int startIndex = Integer.parseInt(data[1]);
            int endIndex = Integer.parseInt(data[2]);

            // Command based text transformation
            switch (command) {

                case UPPERCASE_COMMAND:

                    transformer.toUpperCase(startIndex, endIndex);
                    break;

                case CUT_COMMAND:

                    transformer.cut(startIndex, endIndex);
                    break;

                case PASTE_COMMAND:

                    transformer.paste(startIndex, endIndex);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(transformer);

    }

}