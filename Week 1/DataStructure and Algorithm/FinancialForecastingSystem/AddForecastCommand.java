import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddForecastCommand implements Command {
    private FinancialForecasting forecasting;
    private Scanner scanner;

    public AddForecastCommand(FinancialForecasting forecasting, Scanner scanner) {
        this.forecasting = forecasting;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        double presentValue = getDoubleInput("Enter present value:");
        double growthRate = getDoubleInput("Enter growth rate (as a decimal, e.g., 0.05 for 5%):");
        int years = getIntInput("Enter number of years:");

        // Initialize the memoization map
        Map<Integer, Double> memo = new HashMap<>();

        // Calculate future value
        double futureValue = forecasting.calculateFutureValue(presentValue, growthRate, years, memo);

        System.out.printf("Future value after %d years: %.2f%n", years, futureValue);
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
