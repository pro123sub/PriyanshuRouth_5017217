import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new AddBookCommand(library, scanner));
        commandMap.put(2, new LinearSearchByTitleCommand(library, scanner));
        commandMap.put(3, new LinearSearchByAuthorCommand(library, scanner));
        commandMap.put(4, new BinarySearchByTitleCommand(library, scanner));
        commandMap.put(5, new BinarySearchByAuthorCommand(library, scanner));
        commandMap.put(6, new ExitCommand(scanner));

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Author (Linear Search)");
            System.out.println("4. Search Book by Title (Binary Search)");
            System.out.println("5. Search Book by Author (Binary Search)");
            System.out.println("6. Exit");
            System.out.println("Select your Option");
            int choice = Integer.parseInt(scanner.nextLine());
            Command command = commandMap.get(choice);

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
