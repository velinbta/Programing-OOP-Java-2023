package StudentSystem_03_1;

import java.util.ArrayList;
import java.util.List;

public class StudentSystem {

    private static final List<Student> data = new ArrayList<>();

    private StudentSystem() {
        // Don't let anyone create an instance of this class
    }

    public static void add(Student student) {
        data.add(student);
    }

    public static void printStudentInfo(String name) {
        // Принтира, ако има такъв студент
        data.stream().filter(st -> st.getName().equals(name)).
                findFirst().ifPresent(current -> System.out.printf("%s is %d years old. %s.\n",
                        current.getName(), current.getAge(), getGradeMessage(current)));

    }

    private static String getGradeMessage(Student student) {
        // Съобщение според оценката
        if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
            return "Average student";
        else if (student.getGrade() >= 5.00 && student.getGrade() <= 6.00)
            return "Excellent student";

        return "Very nice person";
    }

}
