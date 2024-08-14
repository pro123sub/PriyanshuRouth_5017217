import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Commands> commandMap = new HashMap<>();
        commandMap.put(1, new AddproductCommand(inventoryManagement, scanner));
        commandMap.put(2, new UpdateProductCommand(inventoryManagement, scanner));
        commandMap.put(3, new DeleteProductCommand(inventoryManagement, scanner));
        commandMap.put(4, new GetProductCommand(inventoryManagement, scanner));

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Get Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 5) {
                System.out.println("Exiting Inventory Management System.");
                scanner.close();
                break;
            }

            Commands command = commandMap.get(choice);
            if (command != null) {
                command.executeCommands();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
