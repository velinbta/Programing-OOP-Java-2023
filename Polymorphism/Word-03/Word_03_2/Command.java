package Word_03_2;

public class Command {

    private final String name;
    private final TextTransform textTransform;

    public Command(String name, TextTransform textTransform){
        this.name = name;
        this.textTransform = textTransform;
    }

    public String getName() {
        return this.name;
    }

    public TextTransform getTextTransform() {
        return this.textTransform;
    }

}
