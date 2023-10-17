package GettersAndSetters_02_1;

import java.lang.reflect.Method;
import java.util.Comparator;

// alphabetically by name
public class MethodNameComparator implements Comparator<Method> {

    @Override
    public int compare(Method f, Method s) {
        return f.getName().compareTo(s.getName());
    }

}
