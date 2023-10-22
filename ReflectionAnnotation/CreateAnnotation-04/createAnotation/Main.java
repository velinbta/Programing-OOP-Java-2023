package createAnotation;

@Subject(categories = "No task presented!")
public class Main {

    public static void main(String[] args) {

        Class<Main> mainClass = Main.class;

        Subject annotation = mainClass.getAnnotation(Subject.class);

        System.out.println(String.join(" ", annotation.categories()));

    }

}
