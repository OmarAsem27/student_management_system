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
            System.out.println("2. Print all students");
            System.out.println("3. Exit");

            if (sc.hasNextInt()) {
                inp = sc.nextInt();

                if (inp >= 1 && inp <= 3) {
                    isInputValid = true;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                sc.next();
            }
        }

        this.processUserRequest(inp);
    }

    private void processUserRequest(int input) {
        if (input == 1) {
            this.AddStudent();
        } else if (input == 2) {
            this.printStudents();
        } else if (input == 3) {
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
}
