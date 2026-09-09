import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    List<Student> studentsList = new ArrayList<>();
    int nextStudentId = 0;

    public void insertStudent(String name, int age, String grade) throws Exception {
        try {
            Student student = new Student(this.nextStudentId, age, name, grade);
            studentsList.add(student);
            this.nextStudentId++;
        } catch (Exception e) {
            throw new Exception("\nFailed to create student: " + e.getMessage() + "\n");
        }
    }

    public void getAllStudents() {
        if (studentsList.size() > 0) {
            for (int i = 0; i < this.studentsList.size(); i++) {

                System.out.printf(
                        "Student Number %d of %d: \nID is %d, name is %s, age is %s, grade is %s%n",
                        i + 1,
                        this.studentsList.size(),
                        this.studentsList.get(i).id,
                        this.studentsList.get(i).name,
                        this.studentsList.get(i).age,
                        this.studentsList.get(i).grade);
            }
        } else {
            System.out.println("no students were found.\n");
        }
    }

    public Student findStudentById(int id) {
        return this.studentsList.stream()
                .filter(s -> s.id == id)
                .findFirst()
                .orElse(null);
    }
}
