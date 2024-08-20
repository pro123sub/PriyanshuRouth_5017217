import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new AddTaskCommand(taskList, scanner));
        commandMap.put(2, new SearchTaskCommand(taskList, scanner));
        commandMap.put(3, new TraverseTasksCommand(taskList));
        commandMap.put(4, new DeleteTaskCommand(taskList, scanner));

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.println("Enter Your Choice");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 5) {
                System.out.println("Exiting...");
                scanner.close();
                return;
            }

            Command command = commandMap.get(choice);

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
