import java.util.Scanner;

public class CommandClasses {
}
class LinearSearchCommand implements Command {
    private Product[] products;

    public LinearSearchCommand(Product[] products) {
        this.products = products;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Enter product name to search (Linear Search): ");
        String linearSearchName = scanner.nextLine();
        Product linearResult = Search.linearSearch(products, linearSearchName);
        if (linearResult != null) {
            System.out.println("Product found: " + linearResult);
        } else {
            System.out.println("Product not found.");
        }
    }
}

class BinarySearchCommand implements Command {
    private Product[] products;

    public BinarySearchCommand(Product[] products) {
        this.products = products;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Enter product name to search (Binary Search): ");
        String binarySearchName = scanner.nextLine();
        Product binaryResult = Search.binarySearch(products, binarySearchName);
        if (binaryResult != null) {
            System.out.println("Product found: " + binaryResult);
        } else {
            System.out.println("Product not found.");
        }
    }
}

class ExitCommand implements Command {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Exiting E-commerce Platform Search.");
        System.exit(0);
    }
}