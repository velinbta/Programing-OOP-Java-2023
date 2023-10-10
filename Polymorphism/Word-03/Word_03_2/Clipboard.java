package Word_03_2;

import java.util.Objects;

public class Clipboard {

    private static String clip;

    private Clipboard() {
        // will contain only static methods
    }

    public static void setClipboard(String clipboard) {
        clip = clipboard;
    }

    public static String getClipboard() {

        if (Objects.isNull(clip)) {
            return "";
        }

        return clip;
    }

}
