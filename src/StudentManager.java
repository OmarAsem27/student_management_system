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
            throw new Exception("\nFailed to create student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        return this.studentsList;
    }

    public Student findStudentById(int id) {
        return this.studentsList.stream()
                .filter(s -> s.id == id)
                .findFirst()
                .orElse(null);
    }

    public void changeStudentName(int id, String name) throws Exception {
        Student student = this.findStudentById(id);
        student.setName(name);
    }

    public void changeStudentAge(int id, int age) throws Exception {
        Student student = this.findStudentById(id);
        student.setAge(age);
    }

    public void changeStudentGrade(int id, String grade) throws Exception {
        Student student = this.findStudentById(id);
        student.setGrade(grade);
    }

    public void deleteStudent(Student student) {
        this.studentsList.remove(student);
    }

}
