package infernoInfinity_1.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface Information {

    String author() default "Pesho";

    int revision() default 3;

    String description() default "Used for Java OOP Advanced course - Enumerations and Annotations.";

    String reviewers() default "Pesho, Svetlio";

}
