import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("1", "Laptop", "Electronics"),
                new Product("2", "Shirt", "Apparel"),
                new Product("3", "Book", "Books"),
                new Product("4", "Smartphone", "Electronics"),
                new Product("5", "Shoes", "Footwear")
        };

        // Sort products by name for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        Scanner scanner = new Scanner(System.in);

        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, new LinearSearchCommand(products));
        commands.put(2, new BinarySearchCommand(products));
        commands.put(3, new ExitCommand());

        while (true) {
            System.out.println("E-commerce Platform Search");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            Command command = commands.get(choice);
            if (command != null) {
                long startTime = System.nanoTime();
                command.execute(scanner);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Time taken: " + duration + " nanoseconds");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
