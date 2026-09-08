public class Student {

    int id;
    int age;
    String grade;
    String name;

    Student(int id, int age, String name, String grade) throws Exception {

        if (!this.validateName(name) || !this.validateAge(age) || !this.validateGrade(grade)) {
            throw new Exception("Failed to create student");
        }
        this.id = id;
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    private boolean validateName(String name) throws Exception {
        if (name.length() < 3 || !name.matches("^[a-zA-Z\\s]+$")) {
            throw new Exception("The name must be at least 3 characters long and does not contain any numbers.");
        }
        return true;
    }

    private boolean validateAge(int age) throws Exception {
        if (age <= 0) {
            throw new Exception("The age must be a valid number.");
        }
        return true;
    }

    private boolean validateGrade(String grade) throws Exception {
        if (!grade.matches("[a-zA-Z]") || grade.length() != 1) {
            grade = grade.toUpperCase();
            throw new Exception("The grade must be one alphapet character.");
        }
        return true;
    }

}
