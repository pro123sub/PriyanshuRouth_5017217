import java.util.Scanner;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create instances
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Find Customer by ID");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 2) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter Customer name");
                    String name= scanner.nextLine();
                    Customer customer = service.getCustomerbyID(id);
                    if (customer != null) {
                        System.out.println("Customer Found:");
                        System.out.println(customer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
