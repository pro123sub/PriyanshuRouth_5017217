import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {
    // Method to calculate future value using recursion and memoization
    public double calculateFutureValue(double presentValue, double growthRate, int years, Map<Integer, Double> memo) {
        // Check if result is already computed
        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        // Base case
        if (years == 0) {
            return presentValue;
        }

        // Recursive case
        double futureValue = calculateFutureValue(presentValue, growthRate, years - 1, memo) * (1 + growthRate);

        // Store the result in the memoization map
        memo.put(years, futureValue);

        return futureValue;
    }
}
