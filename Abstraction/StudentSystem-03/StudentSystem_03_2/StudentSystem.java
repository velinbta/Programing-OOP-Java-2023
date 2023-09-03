package StudentSystem_03_2;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private static final String CREATE_COMMAND = "Create";
    private static final String SHOW_COMMAND = "Show";

    private final Map<String, Student> studentData;

    public StudentSystem() {
        this.studentData = new HashMap<>();
    }

    public void processStudentData(String[] data) {

        String command = data[0];
        String name = data[1];

        switch (command) {

            case CREATE_COMMAND:

                int age = Integer.parseInt(data[2]);
                double grade = Double.parseDouble(data[3]);

                // Създава и добавя студент
                if (!this.studentData.containsKey(name)) {
                    Student student = new Student(name, age, grade);
                    this.studentData.put(name, student);
                }

                break;

            case SHOW_COMMAND:

                // Принтира информацията за студента, ако съществува
                if (!this.studentData.containsKey(name)) {
                    break;
                }

                Student student = this.studentData.get(name);

                String studentInfo = String.format("%s is %s years old. %s",
                        student.getName(), student.getAge(), this.getGradeMessage(student));

                System.out.println(studentInfo);

                break;

        }

    }

    private String getGradeMessage(Student student) {

        // Според оценката
        if (student.getGrade() >= 5.00)
            return "Excellent student.";
        else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
            return "Average student.";

        return "Very nice person.";

    }

}
