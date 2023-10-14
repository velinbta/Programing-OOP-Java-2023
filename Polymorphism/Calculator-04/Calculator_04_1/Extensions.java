package Calculator_04_1;

public class Extensions {

    private Extensions() {
        // will contain only static methods
    }

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new InputInterpreter(engine);
    }

}
