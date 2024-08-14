import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentController {
    private Student student;
    private StudentView view;
    private Map<Integer, Runnable> actions;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
        this.actions = new HashMap<>();
        initializeActions();
    }

    private void initializeActions() {
        actions.put(1, this::displayStudentDetails);
        actions.put(2, this::updateStudentName);
        actions.put(3, this::updateStudentId);
        actions.put(4, this::updateStudentGrade);
    }

    public void displayStudentDetails() {
        view.displayStudentDetails(student);
    }

    public void updateStudentName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        student.setName(newName);
    }

    public void updateStudentId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new ID: ");
        String newId = scanner.nextLine();
        student.setId(newId);
    }

    public void updateStudentGrade() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new grade: ");
        String newGrade = scanner.nextLine();
        student.setGrade(newGrade);
    }

    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. View Student Details");
            System.out.println("2. Update Name");
            System.out.println("3. Update ID");
            System.out.println("4. Update Grade");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            Runnable action = actions.get(choice);
            if (action != null) {
                action.run();
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
