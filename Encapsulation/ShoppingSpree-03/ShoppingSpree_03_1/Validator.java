package ShoppingSpree_03_1;

import java.util.Objects;

public class Validator {

    public static void validateMoney(double money) {
        if (money < 0D)
            throw stateException("Money cannot be negative");
    }

    public static void validateName(String name) {
        if (Objects.isNull(name) || name.isBlank())
            throw stateException("Name cannot be empty");
    }

    private static IllegalStateException stateException(String message) {
        throw new IllegalStateException(message);
    }

}
