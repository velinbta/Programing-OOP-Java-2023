package MilitaryElite_06_1;

public class Mission {

    // State Mission enum
    public enum State {

        IN_PROGRESS,
        FINISHED;

        public static State parseState(String stateAsString) {

            switch (stateAsString) {

                case "inProgress":
                    return IN_PROGRESS;
                case "finished":
                    return FINISHED;
                default:
                    throw argumentException(stateAsString);
            }

        }

        public static String parseState(State state) {

            switch (state) {

                case IN_PROGRESS:
                    return "inProgress";
                case FINISHED:
                    return "finished";
                default:
                    throw argumentException(state.name());

            }

        }

        private static IllegalArgumentException argumentException(String state) {
            throw new IllegalArgumentException("Invalid state " + state);
        }

    }

    private final String codeName;
    private final State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), State.parseState(this.getState()));
    }

}
