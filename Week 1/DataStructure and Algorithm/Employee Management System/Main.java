import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Employee ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over

                    Employee newEmployee = new Employee(addId, name, position, salary);
                    AddEmployeeCommand addCommand = new AddEmployeeCommand(newEmployee, ems);
                    addCommand.execute();
                    break;

                case 2: // Search Employee
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    SearchEmployeeCommand searchCommand = new SearchEmployeeCommand(ems, searchId);
                    searchCommand.execute();
                    break;

                case 3: // Traverse Employees
                    TraverseEmployeesCommand traverseCommand = new TraverseEmployeesCommand(ems);
                    traverseCommand.execute();
                    break;

                case 4: // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    DeleteEmployeeCommand deleteCommand = new DeleteEmployeeCommand(ems, deleteId);
                    deleteCommand.execute();
                    break;

                case 5: // Exit
                    System.out.println("Exiting Employee Management System.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
