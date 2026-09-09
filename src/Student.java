public class Student {

    int id;
    int age;
    String grade;
    String name;

    Student(int id, int age, String name, String grade) throws Exception {
        this.validateName(name);
        this.validateAge(age);
        this.validateGrade(grade);

        this.id = id;
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    public void setAge(int age) throws Exception {
        this.validateAge(age);
        this.age = age;
    }

    public void setGrade(String grade) throws Exception {
        this.validateGrade(grade);
        this.grade = grade;
    }

    public void setName(String name) throws Exception {
        this.validateName(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [id: " + id + ", age: " + age + ", grade: " + grade + ", name: " + name + "]";
    }

    private void validateName(String name) throws Exception {
        if (name.length() < 3 || !name.matches("^[a-zA-Z\\s]+$")) {
            throw new Exception("The name must be at least 3 characters long and does not contain any numbers.");
        }
    }

    private void validateAge(int age) throws Exception {
        if (age <= 0) {
            throw new Exception("The age must be a valid number.");
        }
    }

    private void validateGrade(String grade) throws Exception {
        if (!grade.matches("[a-zA-Z]") || grade.length() != 1) {
            grade = grade.toUpperCase();
            throw new Exception("The grade must be one alphapet character.");
        }
    }

}
