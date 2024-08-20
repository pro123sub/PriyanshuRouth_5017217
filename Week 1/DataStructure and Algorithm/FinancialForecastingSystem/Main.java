import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        Scanner scanner = new Scanner(System.in);

        // Command map to handle different user actions
        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new AddForecastCommand(forecasting, scanner));

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Calculate Future Value");
            System.out.println("2. Exit");

            String input = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                continue;
            }

            if (choice == 2) {
                System.out.println("Exiting...");
                scanner.close();
                break;
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
