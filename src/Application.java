import java.util.List;
import java.util.Scanner;

public class Application {

    Scanner sc;
    StudentManager studentManager;
    final int MAX_OPTIONS = 6;

    Application() {
        this.studentManager = new StudentManager();
        this.sc = new Scanner(System.in);
        System.out.println(
                "\nWelcome to the Student management system.");
    }

    public void collectUserInput() {
        int inp = 0;
        boolean isInputValid = false;

        while (!isInputValid) {
            System.out.println("\nplease, enter your wanted operation number between the following choices:");
            System.out.println("1. Add student");
            System.out.println("2. Find student with ID");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Print all students");
            System.out.println("6. Exit");

            if (sc.hasNextInt()) {
                inp = sc.nextInt();

                if (inp >= 1 && inp <= MAX_OPTIONS) {
                    isInputValid = true;
                } else {
                    System.out.printf("Invalid choice! Please enter a number between 1 and %d.%n", MAX_OPTIONS);
                }
            } else {
                System.out.println("Invalid choice!");
                sc.next();
            }
        }

        this.processUserRequest(inp);
    }

    private void processUserRequest(int input) {
        if (input == 1) {
            this.AddStudent();
        } else if (input == 2) {
            this.find();
        } else if (input == 3) {
            this.update();
        } else if (input == 4) {
            this.delete();
        } else if (input == 5) {
            this.printStudents();
        } else if (input == 6) {
            this.exitApp();
        }
    }

    private void AddStudent() {
        System.out.println("\nplease insert the following information to add the student.");

        if (this.sc.hasNextLine()) {
            this.sc.nextLine();
        }

        System.out.print("student name: ");
        String name = this.sc.next();

        boolean isAgeInteger = false;
        int age = 0;
        while (!isAgeInteger) {
            try {
                System.out.print("student age: ");
                age = sc.nextInt();
                isAgeInteger = true;
            } catch (Exception e) {
                System.out.print("student age must be a number!\n");
                sc.next();
            }
        }

        System.out.print("student grade: ");
        String grade = sc.next();

        try {
            this.studentManager.insertStudent(name, age, grade);
            System.out.println(
                    "\nStudent was added successfully.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.collectUserInput();
    }

    private void printStudents() {
        List<Student> students = studentManager.getAllStudents();

        if (students.size() > 0) {
            for (int i = 0; i < students.size(); i++) {

                System.out.printf(
                        "Student Number %d of %d: \nID is %d, name is %s, age is %s, grade is %s%n",
                        i + 1,
                        students.size(),
                        students.get(i).id,
                        students.get(i).name,
                        students.get(i).age,
                        students.get(i).grade);
            }
        } else {
            System.out.println("no students were found.\n");
        }
        this.collectUserInput();
    }

    private void exitApp() {
        System.out.println("Thank you for using out application.");
        System.exit(0);
    }

    private void find() {
        int inp = this.getValidInputId();
        Student student = this.studentManager.findStudentById(inp);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("\nStudent not found");
        }

        this.collectUserInput();
    }

    private void update() {
        int inp = 0;
        boolean isInputValid = false;
        Student stu = null;
        System.out.println("Enter the ID of the student...");
        while (!isInputValid) {
            if (this.sc.hasNextInt()) {
                inp = this.sc.nextInt();
                isInputValid = true;
                stu = this.studentManager.findStudentById(inp);
            }
        }

        if (stu != null) {
            inp = this.getFeildToUpdate();
        } else {
            System.out.println("\nStudent not found");
        }

        if (inp == 1) {
            this.updateStudentName(stu.id);
        } else if (inp == 2) {
            this.updateStudentAge(stu.id);
        } else if (inp == 3) {
            this.updateStudentGrade(stu.id);
        }

        this.collectUserInput();
    }

    private int getValidInputId() {
        int inp = 0;
        boolean isInputValid = false;

        System.out.println("Enter the ID of the student.");
        while (!isInputValid) {
            /*
             * Handling Bad Input: When the user enters a non-integer, the else block runs.
             * It prints your error message and calls sc.next() to clear the invalid token
             * from the scanner buffer so the program can ask again.
             */
            if (this.sc.hasNextInt()) {
                inp = this.sc.nextInt();
                isInputValid = true;
            } else {
                System.out.println("Invalid input, please try again.");
                this.sc.next();
            }
        }
        return inp;
    }

    private int getFeildToUpdate() {
        int inp = 0;
        boolean isInputValid = false;

        System.out.println("Enter the number of the field you want to update.");
        System.out.println("1.Name.");
        System.out.println("2.Age.");
        System.out.println("3.Grade.");
        while (!isInputValid) {
            if (this.sc.hasNextInt()) {
                inp = this.sc.nextInt();

                if (inp < 0) {
                    System.out.println("Invalid option number.");
                } else {
                    isInputValid = true;
                }
            } else {
                System.out.println("Invalid input, please try again.");
                this.sc.next();
            }
        }
        return inp;
    }

    private void updateStudentName(int id) {
        System.out.println("Enter the new name to update.");
        String name = this.sc.next();
        try {
            this.studentManager.changeStudentName(id, name);
            System.out.println("Student name updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateStudentAge(int id) {
        System.out.println("Enter the new age to update.");
        int age = 0;
        boolean isInputValid = false;
        while (!isInputValid) {
            if (this.sc.hasNextInt()) {
                age = this.sc.nextInt();
                isInputValid = true;
            } else {
                System.out.println("Invalid input...");
                this.sc.next();
            }
        }
        try {
            this.studentManager.changeStudentAge(id, age);
            System.out.println("Student age updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateStudentGrade(int id) {
        System.out.println("Enter the new grade to update.");
        String grade = this.sc.next();
        try {
            this.studentManager.changeStudentGrade(id, grade);
            System.out.println("Student grade updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void delete() {
        int inp = getValidInputId();
        Student stu = this.studentManager.findStudentById(inp);

        if (stu == null) {
            System.out.println("Student not found");
        }
        this.studentManager.deleteStudent(stu);
        System.out.println("Student deleted successfully");
        this.collectUserInput();
    }
}
