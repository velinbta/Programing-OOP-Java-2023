package Word_03_2;

public class Initialization {

    // given missing file in Skeleton
    private Initialization() {
        // will contain only static methods
    }

    public static CommandInterface buildCommandInterface(StringBuilder text) {

        CommandInterface commandInterface = new CommandInterfaceImpl(text);
        commandInterface.init();

        return commandInterface;
    }

}
