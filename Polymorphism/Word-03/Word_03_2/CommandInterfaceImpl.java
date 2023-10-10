package Word_03_2;

import java.util.*;

public class CommandInterfaceImpl implements CommandInterface {

    private final Map<String, TextTransform> commandTransforms;
    private final StringBuilder text;

    public CommandInterfaceImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
    }

    @Override
    public void init() {

        this.commandTransforms.clear();

        for (Command command : this.initCommands()) {
            this.commandTransforms.putIfAbsent(command.getText(), command.getTextTransform());
        }

    }

    @Override
    public void handleInput(String input) {
        String[] data = input.split("\\s+");

        String commandName = data[0];
        int startIndex = Integer.parseInt(data[1]);
        int endIndex = Integer.parseInt(data[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startIndex, endIndex);
    }

    protected Iterable<Command> initCommands() {

        Collection<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new ToCutTransform()));
        commands.add(new Command("paste", new ToPasteTransform()));

        return commands;

    }

}
