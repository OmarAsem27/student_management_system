import java.util.Scanner;

public class Application {

    Scanner sc;
    StudentManager studentManager;

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
            System.out.println("3. Print all students");
            System.out.println("4. Exit");

            if (sc.hasNextInt()) {
                inp = sc.nextInt();

                if (inp >= 1 && inp <= 4) {
                    isInputValid = true;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 3.");
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
            this.printStudents();
        } else if (input == 4) {
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
        studentManager.getAllStudents();

        this.collectUserInput();
    }

    private void exitApp() {
        System.out.println("Thank you for using out application.");
        System.exit(0);
    }

    private void find() {
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

                if (inp < 0) {
                    System.out.println("Invalid input.");
                } else {
                    isInputValid = true;
                }
            } else {
                System.out.println("Invalid input, please try again.");
                this.sc.next();
            }
        }
        Student student = this.studentManager.findStudentById(inp);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("\nStudent not found");
        }

        this.collectUserInput();
    }
}
