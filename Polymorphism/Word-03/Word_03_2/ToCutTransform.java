package Word_03_2;

public class ToCutTransform implements TextTransform {

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        Clipboard.setClipboard(text.substring(startIndex, endIndex));
        text.delete(startIndex, endIndex);

    }

}
