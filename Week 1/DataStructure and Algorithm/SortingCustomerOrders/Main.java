import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an array of orders
        Orders[] orders = {
                new Orders("1", "Alice", 250.75),
                new Orders("2", "Bob", 150.50),
                new Orders("3", "Charlie", 300.00),
                new Orders("4", "Diana", 100.25),
                new Orders("5", "Edward", 275.00)
        };

        // Setup commands
        Command bubbleSortCommand = new BubbleSortCommand(orders.clone());
        Command quickSortCommand = new QuickSortCommand(orders.clone());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sorting Customer Orders");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 1) {
                bubbleSortCommand.execute();
            } else if (choice == 2) {
                quickSortCommand.execute();
            } else if (choice == 3) {
                System.out.println("Exiting Sorting Program.");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
