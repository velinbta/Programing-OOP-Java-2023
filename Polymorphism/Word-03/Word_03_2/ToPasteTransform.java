package Word_03_2;

public class ToPasteTransform implements TextTransform {

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        text.replace(startIndex, endIndex, Clipboard.getClipboard());

    }

}
