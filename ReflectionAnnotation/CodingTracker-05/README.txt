5. Coding Tracker 
Create annotation Author with a String element called name, that:
Should be available at runtime
Can be placed only on methods

Create a class Tracker with a method:
public static void printMethodsByAuthor()

Examples:

@Author(name = "George")
public static void main(String[] args) {
Tracker.printMethodsByAuthor(Tracker.class);
}

@Author(name = "Peter)
public static void printMethodsByAuthor(Class<?> clazz) {...}


Output:
George: main()
Peter: printMethodsByAuthor()